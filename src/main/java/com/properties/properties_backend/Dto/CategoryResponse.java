package com.properties.properties_backend.Dto;

// THIS IS WHAT I RETURN BACK TO THE FRONTEND

import lombok.Data;

@Data
public class CategoryResponse {
    private Long id;

    private String name;

    private String description;
    private String imageUrl;

    private String createdAt;

    private String updatedAt;
}
