package com.netec.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
//@RibbonClient(name="micro-producto")
@EnableFeignClients
@SpringBootApplication
public class CarritoMicroFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarritoMicroFeignApplication.class, args);
	}
	
}
