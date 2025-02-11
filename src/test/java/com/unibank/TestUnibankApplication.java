package com.unibank;

import org.springframework.boot.SpringApplication;

public class TestUnibankApplication {

    public static void main(String[] args) {
        SpringApplication.from(UnibankApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
