package com.globant.blog.controllers;

import com.globant.blog.dtos.TagResponse;
import com.globant.blog.entities.TagEntity;
import com.globant.blog.mappers.TagMapper;
import com.globant.blog.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;
    private final TagMapper tagMapper;

    @GetMapping
    public ResponseEntity<List<TagResponse>> getAllTags(){
        List<TagEntity> tags = tagService.getTags();
        List<TagResponse> tagResponses = tags.stream()
                .map(tagMapper::toTagResponse).toList();

        return ResponseEntity.ok(tagResponses);
    }
}
