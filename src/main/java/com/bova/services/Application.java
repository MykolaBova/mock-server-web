package com.bova.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Special thanks for inspiration, idea and support for Maurizio Moscatelli
 *
 * @Autor
 * Mykola Bova
 * e-mail:                 bova.mykola@gmail.com
 * Skype:                  mykola_bova
 * Blog:                   http://growth4u.blogspot.com/
 * LinkedIn:               http://www.linkedin.com/in/mykbova
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.bova.services.controllers",
    "com.bova.services.controllers.example"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
