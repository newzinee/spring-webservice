package com.treabear.webservice.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.treabear.webservice.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Posts
 * 실제 DB의 테이블과 매칭될 클래스, Entity 클래스
 * @Entity : 테이블과 링크될 클래스임을 나타냄
 * 
 * Request / Response 클래스로 사용하면 안됨.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;
    
    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성
    public Posts(String title, String content, String author) {
        // 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
        this.title = title;
        this.content = content;
        this.author = author;
    }    
}