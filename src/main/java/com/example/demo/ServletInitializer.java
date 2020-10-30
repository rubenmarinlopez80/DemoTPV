package com.example.demo;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;
 
public class ServletInitializer extends SpringBootServletInitializer implements WebApplicationInitializer{
 

	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    	Properties pr = UtilsEnv.getProperties();
        if (pr != null) {
            application.application().setDefaultProperties(pr);
        }
        String entorno = UtilsEnv.getEntorno();
        if (entorno != null) {
            application.application().setAdditionalProfiles(entorno);
        }

        return application.sources(DemoApplication.class);
    }
 
}