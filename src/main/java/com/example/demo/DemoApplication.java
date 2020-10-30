package com.example.demo;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import lombok.extern.slf4j.Slf4j;

@ServletComponentScan
@SpringBootApplication
public class DemoApplication {
	


	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/tpvppademo");
		SpringApplication application = new SpringApplication(DemoApplication.class);
        UtilsEnv.testExternalPropertiesOnTomcat(application);
        application.run(args);
       
	}
}
