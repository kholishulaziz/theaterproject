package com.project.theater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Created by Kholishul_A on 20/04/2018.
 */
@SpringBootApplication
@EnableResourceServer
public class TheaterProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheaterProjectApplication.class, args);
	}

}
