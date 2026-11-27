package com.example.week5.dtoexam.service;

import com.example.week5.dtoexam.domain.Study;
import com.example.week5.dtoexam.dto.StudyForm;
import com.example.week5.dtoexam.repository.StudyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;

@Service    // 이 클래스가 업무 처리를 담당하는 Spring 객체를 의미
            // 이때 Spring이 StudyService 객체를 생성하고 관리
public class StudyService {
    private final StudyRepository studyRepository;

    public StudyService(StudyRepository studyRepository){
        this.studyRepository = studyRepository;
    }

    private final List<Study> studies = new ArrayList<>();  // 흐름 이해 잘 해야함. 이부분. Study 객체의 name/topic/studyHours는 읽어와야 하는데, 이거는 어떻게? id는 secure한 코드로 자동 생성 한다지만, 다른 것들은 Study의 getter 메서드로 불러와야함.

    // 내가 저장은 하지만, 반환은 하지 않도록.(저장은 저장만, 조회는 조회만 하도록 신경쓰기.)
    // 객체의 매개변수 인자 전달 시?, 개수와 그 자료형, (순서?)이 똑같아야함
    public void save(String name, String topic, Integer studyHours){
        Study study = new Study(
          name, topic, studyHours
        );

        studyRepository.save(study);
    }
    // 여기까지 작성했으면 StudyController로 가서 연결시키기

    public List<Study> findAll(){
        return studyRepository.findAll();
    }

    public Study findById(Long id){
        return studyRepository.findById(id)
                .orElseThrow(       // Optional. 이 거는 시험에는 출제 안함.
                        ()-> new IllegalArgumentException(
                                "해당 스터디 신청을 찾을 수 없습니다."
                        )
                );
    }

    /* Transactional 적용 전
    public Study update(Long id, String name, String topic, Integer studyHours){
        Study study = findById(id);
        study.update(name, topic, studyHours);
        return studyRepository.save(study);
    }
    */

    /*
    * Transaction: DB에서 여러 작업을 하나의 단위로 묶어서 처리하는 것(작업 단위)
    * ex) repository의 save()는 트랜잭션 가능. 원래는 조회 먼저 하구 save().
    * jpa는 자동 감지를 해줌.?
    *
    * jpa는 기본적으로 자동 감지 기능이 있다.
    *
    * 적용 전과 후의 차이에 대해 잘 알아둬야할듯.
    *
    * Transactional: Transaction의 시작, commit, Rollback 등을 관리
    * commit: 작업 결과를 db에 최종 확정.
    * Rollback: 작업을 취소하고 트랜젝션 시작 전 상태로 되돌림.
    */

    // Transactional 적용
    // save() 불필요, 트랜잭션 커밋 과정에서 Hibernate가 변경 감지
    @Transactional
    public void update(Long id, String name, String topic, Integer studyHours){
        Study study = findById(id);
        study.setName(name);
        study.setTopic(topic);
        study.setStudyHours(studyHours);
    }

    public void delete(Long id){
        findById(id);
        studyRepository.deleteById(id);
    }

}
