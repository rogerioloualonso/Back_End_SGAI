package br.com.sgai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SgaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgaiApplication.class, args);
	}

}
