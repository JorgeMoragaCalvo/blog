package com.globant.blog.repositories;

import com.globant.blog.entities.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, UUID> {

    @Query("select t from TagEntity t left join fetch t.posts")
    List<TagEntity> findAllWithPostCount();
}
