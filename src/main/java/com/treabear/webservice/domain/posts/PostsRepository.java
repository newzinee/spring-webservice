package com.treabear.webservice.domain.posts;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * PostsRepository
 * DB Layer 접근자
 * JpaRepository<Entity 클래스, PK타입> 상속 시, 기본 CRUD 메소드 생성
 */
public interface PostsRepository extends JpaRepository<Posts, Long> { 
      
    @Query("SELECT p " +
        "FROM Posts p " +
        "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();
}