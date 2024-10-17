package com.exmaple.demo1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Demo1Application implements CommandLineRunner {
    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Value("${app.version}")
    private String appVersion;

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Application run successfully. Env " + this.activeProfile + ". Version " + this.appVersion);
    }
}
