package com.book.config;

import com.book.entity.User;
import com.book.mapper.UserMapper;
import com.book.service.impl.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Resource
    UserAuthService service;

    @Resource
    UserMapper mapper;

    @Resource
    PersistentTokenRepository repository;

    @Bean
    public PersistentTokenRepository jdbcRepository(@Autowired DataSource dataSource){
        JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();  //使用基于JDBC的实现
        repository.setDataSource(dataSource);   //配置数据源
//        repository.setCreateTableOnStartup(true);   //启动时自动创建用于存储Token的表（建议第一次启动之后删除该行）
        return repository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/static/**", "/page/auth/**", "/api/auth/**").permitAll()
                .antMatchers("/page/user/**", "/api/user/**").hasRole("user")
                .antMatchers("/page/admin/**", "/api/admin/**").hasRole("admin")
                .anyRequest().hasAnyRole("user", "admin")
                .and()
                .formLogin()
                .loginPage("/page/auth/login")
                .loginProcessingUrl("/api/auth/login")
                .successHandler(this::onAuthenticationSuccess)
                .and()
                .logout()
                .logoutUrl("/api/auth/logout")
                .logoutSuccessUrl("/login")
                .and()
                .csrf().disable()
                .rememberMe()
                .rememberMeParameter("remember")
                .tokenValiditySeconds(60 * 60 * 24 * 7)
                .tokenRepository(repository);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(service)   //使用自定义的Service实现类进行验证
                .passwordEncoder(new BCryptPasswordEncoder());   //依然使用BCryptPasswordEncoder
    }

    protected void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException,SecurityException{
        HttpSession session = httpServletRequest.getSession();
        User user =  mapper.getPasswordByUsername(authentication.getName());
        session.setAttribute("user",user);
        if (user.getAuth().equals("user")){
            httpServletResponse.sendRedirect("/book/page/auth/index");
        }else{
            httpServletResponse.sendRedirect("/book/page/admin/index");
        }

    }
}
