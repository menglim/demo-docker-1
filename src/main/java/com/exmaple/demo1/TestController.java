package com.exmaple.demo1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Slf4j
@RequestMapping("/api")
public class TestController {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Value("${app.version}")
    private String appVersion;

    @RequestMapping("/hello")
    public ResponseEntity<Object> getHello() {
        log.info("Accessing via Hello. AppVersion " + appVersion + ". Env " + activeProfile.toUpperCase() + " at " + new Date());
        return ResponseEntity.ok(new Hello("Hello " + appVersion));
    }
}
