package com.realeasy.portalscrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PortalScrapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalScrapperApplication.class, args);
	}

}
