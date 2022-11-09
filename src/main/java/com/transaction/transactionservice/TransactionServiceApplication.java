package com.transaction.transactionservice;

		import com.transaction.transactionservice.service.TransactionService;
		import com.transaction.transactionservice.service.TransactionServiceImpl;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
		import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class TransactionServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(TransactionServiceApplication.class, args);
	}
}