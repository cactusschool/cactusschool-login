package com.ashish.jwt.token.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// This exclusion is needed to avoid auto generation of password with 
// "Using generated security password:" message in the logfile
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class },
			scanBasePackages={"com.ashish.jwt.token"})
public class LoginApplication {

	private final static Logger logger = LoggerFactory.getLogger(LoginApplication.class);
	public static void main(String[] args) {
		logger.debug(">>>>>>>>>>>>>Starting Login application>>>>>");
		SpringApplication.run(LoginApplication.class, args);
		logger.debug("<<<<<<<<Started Login application<<<<<<<<<<<<<<");
	}

}

