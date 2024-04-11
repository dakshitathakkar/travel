package com.triptrace.travel;

import com.triptrace.travel.dao.repositories.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableTransactionManagement
@EntityScan(basePackages = "com.triptrace.travel.dao.entities")
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class TripTraceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripTraceApplication.class, args);
	}

}
