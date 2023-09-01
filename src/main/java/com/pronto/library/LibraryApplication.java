package com.pronto.library;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


/**
 * The type Library application.
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class LibraryApplication {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

}
