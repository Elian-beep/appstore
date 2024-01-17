package com.kihan.appstore;

import com.kihan.appstore.entity.App;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.time.LocalDate;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class })
public class AppstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppstoreApplication.class, args);
	}

}
