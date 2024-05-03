package com.OneToOne.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OneToOne.IService.CategoryIService;
import com.OneToOne.Model.Category;
@RequestMapping("/api/v1.0/category")
@RestController
public class CategoryController {
	@Autowired
	private CategoryIService categoryIservice;
	@PostMapping("/save")
public ResponseEntity<?> saveCategory(@RequestBody Category dto){
		ResponseEntity<?>  data=categoryIservice.saveCategory(dto);
		return data;
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable Long id){
			ResponseEntity<?>  data=categoryIservice.getCategoryById(id);
			return data;
		}
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllCategory( ){
			ResponseEntity<?>  data=categoryIservice.getAllCategory();
			return data;
		}
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> getDeleteCategory( @PathVariable Long id){
			ResponseEntity<?>  data=categoryIservice.getDeleteCategory(id);
			return data;
		}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateCategory( @PathVariable Long id,@RequestBody Category dto){
			ResponseEntity<?>  data=categoryIservice.updateCategory(id,dto);
			return data;
		}
}
