package com.book.initializer;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.ServletContext;

@EnableWebSecurity
@Configuration
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
        servletContext.addFilter("characterEncodingFilter", new CharacterEncodingFilter("UTF-8", true))
                .addMappingForUrlPatterns(null, false, "/*");
    }
}
