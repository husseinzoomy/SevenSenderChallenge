package com.ss.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SevenSendersChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SevenSendersChallengeApplication.class, args);
	}

}
