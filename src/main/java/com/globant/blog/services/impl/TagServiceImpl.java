package com.globant.blog.services.impl;

import com.globant.blog.entities.TagEntity;
import com.globant.blog.repositories.TagRepository;
import com.globant.blog.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public List<TagEntity> getTags() {
        return tagRepository.findAllWithPostCount();
    }
}
