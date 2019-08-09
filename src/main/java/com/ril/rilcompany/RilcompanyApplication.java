package com.ril.rilcompany;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ril.rilcompany.mapper")
public class RilcompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RilcompanyApplication.class, args);
	}

}
