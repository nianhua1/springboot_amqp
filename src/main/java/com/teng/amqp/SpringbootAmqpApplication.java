package com.teng.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class SpringbootAmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAmqpApplication.class, args);
	}

}
