package com.learning.server.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServerDiscoveryServiceLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerDiscoveryServiceLearningApplication.class, args);
	}

}
