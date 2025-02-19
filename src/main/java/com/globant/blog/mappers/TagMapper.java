package com.globant.blog.mappers;

import com.globant.blog.dtos.TagResponse;
import com.globant.blog.entities.PostEntity;
import com.globant.blog.entities.PostStatus;
import com.globant.blog.entities.TagEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TagMapper {

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    TagResponse toTagResponse(TagEntity tag);

    @Named("calculatePostCount")
    default Integer calculatePostCount(Set<PostEntity> posts){
        if(posts == null) return 0;

        return (int) posts.stream()
                .filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }
}
