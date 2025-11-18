package com.properties.properties_backend.Dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

// THIS IS WHAT THE USER/FRONTEND SENDS TO ME
@Data
public class CategoryRequest {
    @NotBlank(message = "Category name is required")
    private String name;
    private String description;
    private String imageUrl;

}
