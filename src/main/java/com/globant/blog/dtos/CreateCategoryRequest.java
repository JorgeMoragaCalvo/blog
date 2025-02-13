package com.globant.blog.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryRequest {

    @NotBlank(message = "Category name us required")
    @Size(min = 2, max = 50, message = "Category must be between {min} an {max} characters")
    @Pattern(regexp = "^[\\w\\s-]+$", message = "Only contains letters, numbers, spaces and hyphens")
    private String name;
}
