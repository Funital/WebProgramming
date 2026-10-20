package com.example.week5.dtoexam.domain;

//name/topic/studyHours => mapping(해서) -> study-result로 전달해주야 함.
//name/topic/studyHours => mapping(해서) -> 객체 (Study) -> List 로 보내도록 추가 보완해주면 된다. 이 List는 이후 DB로.

public class Study {
    private Long id;
    private String name;
    private String topic;
    private Integer studyHours;

    public Study(Long id, String name, String topic, Integer studyHours) {
        this.id = id;
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
}
