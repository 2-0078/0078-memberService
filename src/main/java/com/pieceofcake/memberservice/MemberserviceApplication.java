package com.pieceofcake.memberservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@EnableDiscoveryClient
@SpringBootApplication
public class MemberserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberserviceApplication.class, args);
	}

}
