package com.example.week04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloViewController {
    @GetMapping("/hello-view")
    public String StringHelloView(
            @RequestParam(name="name", defaultValue = "학생") String name, Model model) {
            // Model: Controller 만든 데이터를 HTML 화면으로 전달하기 위한 객체
            model.addAttribute("name", name);
            // 첫 번째 name: HTML 에서 ${name}으로 꺼내 쓸 이름
            // 두 번째 name: JAVA 변수, 실제로 선언된 자바 변수 이름을 써야함.
            return "hello";     // -> templates/hello.html
    }
}
