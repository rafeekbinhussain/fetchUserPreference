package com.preference.userprofile;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class FetchUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(FetchUserApplication.class, args);
	}

}
