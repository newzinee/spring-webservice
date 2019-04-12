package com.treabear.webservice.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

/**
 * BaseTimeEntity
 * Entity들의 createdDate, modifiedDate를 자동으로 관리하는 역할
 * 
 * @MappedSuperclass: JPA Entity 크래스들이 BasteTimeEntity를 상속할 경우, 필드들(createdDate, modifiedDate)도 컬럼으로 인식하도록 함.
 * 
 * @EntityListeners(AuditingEntityListener.class) Auditing 기능을 포함
 * 
 * @CreatedDate: Entity가 생성되어 저장될 때 시간이 자동 저장
 * @LastModifiedDate: 조회한 Entity의 값을 변경할 때 시간이 자동 저장
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
    
}