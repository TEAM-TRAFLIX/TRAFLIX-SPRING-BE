package org.example.traflixspringbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TraflixSpringBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TraflixSpringBeApplication.class, args);
    }

}
