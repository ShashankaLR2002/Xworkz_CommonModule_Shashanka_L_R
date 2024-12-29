package com.xworkz.cmodule.initialization;

import com.xworkz.cmodule.configuration.Configure;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class Initialize extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{Configure.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
