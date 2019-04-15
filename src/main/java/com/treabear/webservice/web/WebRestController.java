package com.treabear.webservice.web;

import java.util.Arrays;

import com.treabear.webservice.domain.dto.PostsSaveRequestDto;
import com.treabear.webservice.domain.posts.PostsRepository;
import com.treabear.webservice.service.PostsService;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

/**
 * WebRestController
 * 
 * @AllArgsConstructor: PostsRepository 생성자 주입을 위해
 * public WebRestController(PostsRepository postsRepository) {
 *     this.postsRepository = postsRepository;
 * }
 * 
 */
@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;
    private Environment env;

    @GetMapping("/profile")
    public String getProfile() {
        // 프로젝트의 환경설정 값을 다루는 Environment Bean을 DI받아 활성화된 profile을 반환하는 코드.
        return Arrays.stream(env.getActiveProfiles())
                    .findFirst()
                    .orElse("");
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello world!";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
        // 테스트 완료 후, DB에 값이 들어가는지 확인을 위한 API
        /*
            {
                "title": "테스트 타이틀",
                "content": "테스트 본문",
                "author": "테스터"
            }
        */
        return postsService.save(dto);
    }
    
}