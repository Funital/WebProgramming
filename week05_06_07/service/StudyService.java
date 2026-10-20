package com.example.week5.dtoexam.service;

import com.example.week5.dtoexam.domain.Study;
import com.example.week5.dtoexam.dto.StudyForm;
import org.springframework.stereotype.Service;

import java.util.*;

@Service    // 이 클래스가 업무 처리를 담당하는 Spring 객체를 의미
            // 이때 Spring이 StudyService 객체를 생성하고 관리
public class StudyService {
    private final List<Study> studies = new ArrayList<>();  // 흐름 이해 잘 해야함. 이부분. Study 객체의 name/topic/studyHours는 읽어와야 하는데, 이거는 어떻게? id는 secure한 코드로 자동 생성 한다지만, 다른 것들은 Study의 getter 메서드로 불러와야함.
    private Long sequence = 1L;

    // 내가 저장은 하지만, 반환은 하지 않도록.(저장은 저장만, 조회는 조회만 하도록 신경쓰기.)
    // 객체의 매개변수 인자 전달 시?, 개수와 그 자료형, (순서?)이 똑같아야함
    public void save(StudyForm studyForm){
        Study study = new Study(
          sequence++, studyForm.getName(), studyForm.getTopic(), studyForm.getStudyHours()
        );

        studies.add(study);
    }
    // 여기까지 작성했으면 StudyController로 가서 연결시키기

    public List<Study> findAll(){
        return studies;
    }
}
