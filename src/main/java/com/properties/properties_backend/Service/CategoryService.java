package com.properties.properties_backend.Service;

import com.properties.properties_backend.Dto.CategoryRequest;
import com.properties.properties_backend.Dto.CategoryResponse;
import com.properties.properties_backend.mapper.CategoryMapper;
import com.properties.properties_backend.model.Category;
import com.properties.properties_backend.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

//     create category

    public CategoryResponse createCategory(CategoryRequest request){
        Category category = categoryMapper.toEntity(request);  //because we are created the mapper so it is easy
        Category saveCategory = categoryRepository.save(category);
        return categoryMapper.toResponse(saveCategory);
    }

// get all category

    public List<CategoryResponse> getAllCategory(){  //categoryMapper::toResponse means Take each item and pass it to the toResponse() method.
        return categoryRepository.findAll().stream().map(categoryMapper::toResponse).collect(Collectors.toList());
    }

//    get all category by id

    public CategoryResponse getCategoryById(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found with id:  + id"));

        return  categoryMapper.toResponse(category);
    }

//    update category

    public CategoryResponse updateCategory(Long id, CategoryRequest request){
        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found with id:  + id"));

        category.setName(request.getName());
        category.setDescription(request.getDescription());
        Category updatedCategory = categoryRepository.save(category);
        return categoryMapper.toResponse(updatedCategory);
    }
    //         delete category
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        categoryRepository.delete(category);
    }
}
