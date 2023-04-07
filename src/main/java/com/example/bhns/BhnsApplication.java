package com.example.bhns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //len lich chay cac tac vu tu dong
public class BhnsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BhnsApplication.class, args);
	}

}
