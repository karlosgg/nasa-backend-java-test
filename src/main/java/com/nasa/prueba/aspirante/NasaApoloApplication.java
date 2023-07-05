package com.nasa.prueba.aspirante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableFeignClients
public class NasaApoloApplication {

	public static void main(String[] args) {
		SpringApplication.run(NasaApoloApplication.class, args);
	}

}
