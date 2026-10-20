package com.example.week5.dtoexam.controller;

import com.example.week5.dtoexam.dto.StudyForm;
import com.example.week5.dtoexam.service.StudyService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// ctrl+alt+o: 필요없는 import문 정리

@Controller
@RequestMapping("/study")
public class StudyController {
    private final StudyService studyService;
    public StudyController(StudyService studyService){
        this.studyService = studyService;
    }
    /* 생성자 주입 : Spring이 생성한 studyService 객체를 전달을 받아서 관리
                : Spring 컨테이너가 관리하는 의존 객체를 생성자를 통해서 전달하는 방식.
                : 생성자 주입에서는 의존성을 고려하기 위해 자주 사용

     */

    @GetMapping("/new")
    public String showStudyForm(
        Model model
    ){
        model.addAttribute("studyForm", new StudyForm());
        return "study-form";
    }

    @PostMapping
    public String applyStudy(
            @Valid @ModelAttribute("studyForm")StudyForm studyForm, BindingResult bindingResult
    ){
        if(bindingResult.hasErrors()){
            return "study-form";
        }

        // mapping 시키기
        // StudyService의 save() 함수에서 ~.
        studyService.save(studyForm);

        return "redirect:/study";   // @RequestMapping으로, redirect : GetMapping으로.
        /* @ModelAttribute의 역할
        * 1. 폼에서 전달된 name, topic, studyHours와 값을 StudyForm 개체의 같은 이름을 가진 프로퍼티에 자동으로 바인딩
        * 2. 만들어진 StudyForm 객체를 studyForm 이라는 이름으로 Model에 자동으로 추가
        * */

    }

    /* **중요**
    @Valid: StudyForm 객체의 검증 조건을 검사하도록 요청
    BindingResult: 검증 대상 모델 객체 바로 뒤에 두어야 해당 객체의 바인딩, 오류를 Controller가 처리할 수 있다.
    오류가 하나라도 있으면 결과 화면으로 진행되지 않고 study-form 화면에 머물러 있음.
     */

    @GetMapping
    public String showStudyList(Model model){
        model.addAttribute("studies", studyService.findAll());
        return "study-list";
    }
}
