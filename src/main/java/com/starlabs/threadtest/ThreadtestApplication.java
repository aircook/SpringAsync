package com.starlabs.threadtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class ThreadtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreadtestApplication.class, args);
    }

}
