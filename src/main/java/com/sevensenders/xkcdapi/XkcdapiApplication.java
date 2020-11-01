package com.sevensenders.xkcdapi;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sun.syndication.io.FeedException;

@SpringBootApplication
public class XkcdapiApplication {

	public static void main(String[] args) throws IOException, IllegalArgumentException, FeedException {
		SpringApplication.run(XkcdapiApplication.class, args);
	}

}
