package com.treabear.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import com.treabear.webservice.domain.dto.PostsMainResponseDto;
import com.treabear.webservice.domain.dto.PostsSaveRequestDto;
import com.treabear.webservice.domain.posts.PostsRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

/**
 * PostsService
 */
@AllArgsConstructor
@Service
public class PostsService {

    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }

    
    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {

        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }
    
}