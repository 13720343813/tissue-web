package com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TissueWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TissueWebApplication.class, args);
    }

}
