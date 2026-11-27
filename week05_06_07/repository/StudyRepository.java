package com.example.week5.dtoexam.repository;

import com.example.week5.dtoexam.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;

/* StudyRepository: Study Entity의 db 접근을 담당
   JpaRepository<Study, Long>=> Study: 관리할 엔티티 클래스, Long: 해당 Entity의 기본키의 자료형

   JpaRepository를 상속을 받으면 Spring Data JPA가 저장, 조회, 수정, 삭제(CRUD) 등이 기본 데이터베이스 작업을
   구현하지 않아도 사용할 수 있다.
 */
public interface StudyRepository extends JpaRepository<Study, Long> {
    /*
        save(): 저장, 변경
        findAll(): 조회
        findById(): 특정 id 조회
        deleteById(): 특정 id 삭제

     */
}
