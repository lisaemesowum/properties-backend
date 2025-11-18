package com.properties.properties_backend.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PropertyRequest {

    @NotBlank(message = "Property name is required")
    private String name;

    private String description;

    private String CategoryName;

    private Double price;

    private String location;

    private String imageUrl;  // frontend provides the image URL


}
