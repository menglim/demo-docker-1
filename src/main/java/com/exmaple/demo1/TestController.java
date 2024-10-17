package com.exmaple.demo1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @RequestMapping("/hello")
    public ResponseEntity<Object> getHello() {
        return ResponseEntity.ok(new Hello("Hello "));
    }
}
