package com.properties.properties_backend.Service;

import com.properties.properties_backend.Dto.PropertyRequest;
import com.properties.properties_backend.Dto.PropertyResponse;
import com.properties.properties_backend.mapper.PropertyMapper;
import com.properties.properties_backend.model.Category;
import com.properties.properties_backend.model.Property;
import com.properties.properties_backend.repository.CategoryRepository;
import com.properties.properties_backend.repository.PropertyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PropertyService {
    private final PropertyRepository propertyRepository;
    private final CategoryRepository categoryRepository;
    private final PropertyMapper propertyMapper;

    // Create a new property

    public PropertyResponse createProperty(PropertyRequest request) {
        Category category = categoryRepository.findByName(request.getCategoryName())
                .orElseThrow(() -> new RuntimeException("Category not found with name: " + request.getCategoryName()));

        Property property = propertyMapper.toEntity(request, category);
        Property savedProperty = propertyRepository.save(property);
        return propertyMapper.toResponse(savedProperty);
    }

    // Get all properties

    public List<PropertyResponse> getAllProperties() {
        return propertyRepository.findAll()
                .stream()
                .map(propertyMapper::toResponse)
                .collect(Collectors.toList());
    }

    // Get property by ID

    public PropertyResponse getPropertyById(Long id) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found with id: " + id));
        return propertyMapper.toResponse(property);
    }

    // Delete a property

    public void deleteProperty(Long id) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found with id: " + id));
        propertyRepository.delete(property);
    }

    // Update property

    public PropertyResponse updateProperty(Long id, PropertyRequest request) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found with id: " + id));

        Category category = categoryRepository.findByName(request.getCategoryName())
                .orElseThrow(() -> new RuntimeException("Category not found with name: " + request.getCategoryName()));

        property.setName(request.getName());
        property.setDescription(request.getDescription());
        property.setCategory(category);
        property.setPrice(request.getPrice());
        property.setLocation(request.getLocation());
        property.setImageUrl(request.getImageUrl());
        property.setUpdatedAt(java.time.LocalDateTime.now());

        Property updatedProperty = propertyRepository.save(property);
        return propertyMapper.toResponse(updatedProperty);
    }


    public List<PropertyResponse> getPropertiesByCategory(String categoryName) {
        List<Property> properties = propertyRepository.findByCategory_Name(categoryName);

        return properties.stream()
                .map(propertyMapper::toResponse)
                .collect(Collectors.toList());
    }

}

