package com.example.demo.spboot;

import com.example.demo.DemoApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
public class SpAction {
    public static void main(String[] args) {
        SpringApplication.run(SpAction.class, args);
    }
}
