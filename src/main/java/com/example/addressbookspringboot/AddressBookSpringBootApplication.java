package com.example.addressbookspringboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class AddressBookSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressBookSpringBootApplication.class, args);
        log.info("Welcome to the address Book..... ");
    }

}
