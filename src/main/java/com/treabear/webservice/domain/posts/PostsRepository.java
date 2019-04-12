package com.treabear.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PostsRepository
 * DB Layer 접근자
 * JpaRepository<Entity 클래스, PK타입> 상속 시, 기본 CRUD 메소드 생성
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {   
}