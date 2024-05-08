package com.homepage.likelion.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/simpleText")
public class SimpleTestController {

    // GET http://localhost:8080/api/simpleText/success
    // 위 경로로 요청이 들어오면 "안녕"이라는 문장을 리턴하는 api
    @GetMapping("/success")
    public String simpleTextSuccess() {
        return "안녕";
    }

    // GET http://localhost:8080/api/simpleText/fail
    @GetMapping("/fail")
    public ResponseEntity<String> simpleTextFail() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("실패");
    }
}
