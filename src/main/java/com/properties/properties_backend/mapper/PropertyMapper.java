package com.properties.properties_backend.mapper;

import com.properties.properties_backend.Dto.PropertyRequest;
import com.properties.properties_backend.Dto.PropertyResponse;
import com.properties.properties_backend.model.Category;
import com.properties.properties_backend.model.Property;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public class PropertyMapper {
    // Convert DTO request to Entity
    public Property toEntity(PropertyRequest request, Category category) {
        if (request == null) return null;

        Property property = new Property();
        property.setName(request.getName());
        property.setDescription(request.getDescription());
        property.setCategory(category); // link category entity
        property.setPrice(request.getPrice());
        property.setLocation(request.getLocation());
        property.setImageUrl(request.getImageUrl());
        return property;
    }

    // Convert Entity to Response DTO
    public PropertyResponse toResponse(Property property) {
        if (property == null) return null;

        PropertyResponse response = new PropertyResponse();
        response.setId(property.getId());
        response.setName(property.getName());
        response.setDescription(property.getDescription());
        response.setCategoryName(property.getCategory() != null ? property.getCategory().getName() : null);
        response.setPrice(property.getPrice());
        response.setLocation(property.getLocation());
        response.setImageUrl(property.getImageUrl());
        response.setCreatedAt(property.getCreatedAt());
        response.setUpdatedAt(property.getUpdatedAt());
        return response;
    }
}
