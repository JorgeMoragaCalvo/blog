package com.globant.blog.repositories;

import com.globant.blog.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID> {

    @Query("select c from CategoryEntity c left join fetch c.posts")
    List<CategoryEntity> findAllWithPostCount();

    boolean existsByNameIgnoreCase(String name);
}
