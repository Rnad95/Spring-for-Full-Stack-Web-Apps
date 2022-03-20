package com.example.songr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SpringBootApplication
public class SongrApplication {
	public static void main(String[] args) {
		SpringApplication.run(SongrApplication.class, args);
	}

}
