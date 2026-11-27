package com.example.week5.dtoexam.domain;

//name/topic/studyHours => mapping(해서) -> study-result로 전달해주야 함.
//name/topic/studyHours => mapping(해서) -> 객체 (Study) -> List 로 보내도록 추가 보완해주면 된다. 이 List는 이후 DB로.

import jakarta.persistence.*;

// @Entity가 붙으면 Study는 단순한 java 객체가 아니라 JPA가 관리하는 Entity
// db 테이블과 매핑이 되는 객체
// @GeneratedValue: 기본키 값을 자동으로 생성하도록 지정
// IDENTITY: db의 자동 증가 기능을 이용해서 id를 생성하는 방식
@Entity
public class Study {
    @Id // 이 필드를 기본키(PK)로 사용하겠다는 의미, db의 각 행을 구별
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String topic;
    private Integer studyHours;

    /* JPA가 데이터베이스 조회 결과를 이용하여 Study 객체를 만들 떄 사용하는 기본 생성자.
        public, protected
     */
    protected Study() {}    // 기본 생성자

    public Study(String name, String topic, Integer studyHours) {
        this.name = name;
        this.topic = topic;
        this.studyHours = studyHours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getStudyHours() {
        return studyHours;
    }

    public void setStudyHours(Integer studyHours) {
        this.studyHours = studyHours;
    }

    /* Transactional 적용 전
    public void update(String name, String topic, Integer studyHours){
        this.name=name;
        this.topic=topic;
        this.studyHours=studyHours;
    }
    */

}
