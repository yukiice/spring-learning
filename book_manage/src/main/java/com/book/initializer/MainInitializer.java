package com.book.initializer;

import com.book.config.MainConfiguration;
import com.book.config.MvcConfiguration;
import com.book.config.SecurityConfiguration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MainInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        servletContext.addFilter("CharacterEncodingFilter",new CharacterEncodingFilter("UTF-8",true))
//                .addMappingForUrlPatterns(null,false,"/*");
//        super.onStartup(servletContext);
//    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{MainConfiguration.class, SecurityConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
