package com.preference.userprofile;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
@Slf4j
public class FetchUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(FetchUserApplication.class, args);
        log.info("Welcome to TB Pay Fetch user Preferences Service");
    }

}
