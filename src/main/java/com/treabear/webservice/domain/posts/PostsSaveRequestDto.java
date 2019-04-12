package com.treabear.webservice.domain.posts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * PostsSaveRequestDto
 * Controller에서 사용할 DTO 클래스
 * 
 * Controller에서 @RequestBody로 외부에서 데이터를 받는 경우엔 
 * 기본 생성자 + set 메소드를 통해서만 값이 할당됩니다. 
 */
@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}