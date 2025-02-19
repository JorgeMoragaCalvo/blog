package com.globant.blog.services;

import com.globant.blog.entities.TagEntity;

import java.util.List;

public interface TagService {

    List<TagEntity> getTags();
}
