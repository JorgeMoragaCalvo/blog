package com.globant.blog.mappers;

import com.globant.blog.dtos.CategoryDTO;
import com.globant.blog.dtos.CreateCategoryRequest;
import com.globant.blog.entities.CategoryEntity;
import com.globant.blog.entities.PostEntity;
import com.globant.blog.entities.PostStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    CategoryDTO toDto(CategoryEntity category);

    CategoryEntity toEntity(CreateCategoryRequest categoryRequest);

    @Named("calculatePostCount")
    default long calculatePostCount(List<PostEntity> posts){
        if(null == posts) return 0;

        return posts.stream()
                .filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }
}
