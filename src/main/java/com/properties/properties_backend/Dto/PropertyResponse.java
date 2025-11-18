package com.properties.properties_backend.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PropertyResponse {
    private Long id;
    private String name;
    private String description;
    private String categoryName; // send category name instead of ID
    private Double price;
    private String location;
    private String imageUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
