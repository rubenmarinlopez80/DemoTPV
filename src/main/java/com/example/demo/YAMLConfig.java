package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfig {
	
	@Value("${spring.webservice.soap.ppaTPVurl}")
    private String ppaTPVurl;
	@Value("${spring.webservice.soap.user}")
	private String user;
	@Value("${spring.webservice.soap.password}")
	private String password;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPpaTPVurl() {
		return ppaTPVurl;
	}

	public void setPpaTPVurl(String ppaTPVurl) {
		this.ppaTPVurl = ppaTPVurl;
	}

 
}