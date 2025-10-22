package com.alpacaflow.meditrackplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MeditrackPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeditrackPlatformApplication.class, args);
    }

}
