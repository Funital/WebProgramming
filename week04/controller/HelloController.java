package com.example.week04.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello Spring Boot";
    }

    @GetMapping("/hello2")
    public String hello2(){
        return "Hello Spring Boot!!!!!!";
    }

    // **시험**
    // 앞 name: @RequestParam 어노테이션의 속성 이름
    // 뒤 name: 브라우저가 보내는 요청 파라미터의 이름
    // String name: 자바의 변수 이름
    @GetMapping("/welcome")
    public String welcome(
            @RequestParam(name="name", defaultValue = "학생") String name
    ){
        return name+"님 환영합니다.";
    }

    @GetMapping("/welcome2")
    public String welcome2(
            @RequestParam(name = "name", defaultValue = "학생") String name,
            @RequestParam(name = "part", defaultValue = "컴공") String part
    ) {
        return name + "님의 전공은 " + part + "입니다.";
    }
}
