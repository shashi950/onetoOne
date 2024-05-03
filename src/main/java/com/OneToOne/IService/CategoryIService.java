package com.OneToOne.IService;

import org.springframework.http.ResponseEntity;

import com.OneToOne.Model.Category;

public interface CategoryIService {

	ResponseEntity<?> saveCategory(Category dto);

	ResponseEntity<?> getCategoryById(Long id);

	ResponseEntity<?> getAllCategory();

	ResponseEntity<?> getDeleteCategory(Long id);

	ResponseEntity<?> updateCategory(Long id, Category dto);

}
