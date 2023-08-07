package com.todolist.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor // 모든 필드를 포함하는 생성자를 자동생성
@NoArgsConstructor // 파라미터 없는 기본 생성자를 자동생성

@Table(name = "TODOS") // Todo 클래스가 데이터베이스의 TODOS 테이블과 매핑됨
public class Todo {
    @Id // 해당 필드가 엔티티의 primary key 임을 지정. 이 필드를 기준으로 엔티티 식별, 관리
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // primary key 값을 자동으로 생성
    // GenerationType.IDENTITY : 데이터베이스의 자동증가를 이용하여 primary key 값 생성..
    private Long id;

    private String title;

   private int todoOrder;

   private boolean completed = false;
}
