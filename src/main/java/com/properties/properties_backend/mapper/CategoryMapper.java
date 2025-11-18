package com.properties.properties_backend.mapper;

import com.properties.properties_backend.Dto.CategoryRequest;
import com.properties.properties_backend.Dto.CategoryResponse;
import com.properties.properties_backend.model.Category;
import org.springframework.stereotype.Component;

//The Mapper translates between DTO and Entity.
@Component
public class CategoryMapper {

//    convert DTO/request to entity
    public Category toEntity(CategoryRequest request){
        if(request ==null)
            return null;

        Category category = new Category();
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        return  category;
    }

//    convert DTO/response
    public CategoryResponse toResponse(Category category){
        if(category == null)
            return null;

        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        response.setDescription(category.getDescription());
//        response.setCreatedAt(category.setCreatedAt(LocalDateTime.now()));
        response.setUpdatedAt(String.valueOf(category.getUpdatedAt()));
        return response;
    }
}
