package com.OneToOne.Service;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.net.ssl.SSLEngineResult.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.OneToOne.Exception.CommonException;
import com.OneToOne.IService.CategoryIService;
import com.OneToOne.Model.Category;
import com.OneToOne.Model.Product;
import com.OneToOne.Repository.CategoryRepository;
import com.OneToOne.Repository.ProductRepository;

@Service
public class CategoryService implements CategoryIService{
	private final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;


	@Override
	public ResponseEntity<?> saveCategory(Category dto) {
		try {
			LOGGER.info("Product data is {} :",dto);
			
		Set<Product> products=dto.getProducts();
		Set<Product> update=new HashSet<>();
		Date d=new Date();
		for(Product p: products) {
			p.setCreatedAt(d);
			update.add(p);
		}
		dto.setProducts(update);
		categoryRepository.save(dto);
		return ResponseEntity.status(HttpStatus.OK).body(update);
		}
		catch(Exception e) {
			LOGGER.info("Category data save error {} :",e.getMessage());
			return ResponseEntity.status(HttpStatus.OK).body("Please save afer some time!");	
		}

	}

	@Override
	public ResponseEntity<?> getCategoryById(Long id) {
		try {
			Optional<Category> data=categoryRepository.findById(id);
			if(data.get()!=null) {
				return ResponseEntity.status(HttpStatus.OK).body(data);
			}
			return ResponseEntity.status(HttpStatus.OK).body("Products does not Exist");
			}
			catch(Exception e) {
				LOGGER.info("get byProduct Id error msg {} :",e.getMessage());
				throw new CommonException("Please try after  some times!");
			}
	}

	@Override
	public ResponseEntity<?> getAllCategory() {
		try {
			List<Category> data=categoryRepository.findAll();
			if(data.size()!=0) {
				return ResponseEntity.status(HttpStatus.OK).body(data);
			}
			return ResponseEntity.status(HttpStatus.OK).body("Products does not Exist");
			}
			catch(Exception e) {
				LOGGER.info("get byProduct Id error msg {} :",e.getMessage());
				throw new CommonException("Please try after  some times!");
			}
	}

	@Override
	public ResponseEntity<?> getDeleteCategory(Long id) {
		try {
			Optional<Category> data=categoryRepository.findById(id);
			if(data.get()!=null) {
				categoryRepository.delete(data.get());
				List<Product> productList=productRepository.findByCategoryId(id);
				if(productList.size()!=0) {
					productRepository.deleteAll(productList);
				}
				return ResponseEntity.status(HttpStatus.OK).body("category delete sucessfully!");
			}
			return ResponseEntity.status(HttpStatus.OK).body("category does not Exist");
			}
			catch(Exception e) {
				LOGGER.info("get by category Id error msg {} :",e.getMessage());
				return ResponseEntity.status(HttpStatus.OK).body("Please try after sometime!");
			}
	}

	@Override
	public ResponseEntity<?> updateCategory(Long id, Category dto) {
		try {
			Optional<Category> data=categoryRepository.findById(id);
			if(data.get()!=null) {
				Date d=new Date();
				Set<Product> update=new HashSet<>();
				for(Product p: data.get().getProducts()) {
					p.setCreatedAt(d);
					update.add(p);
				}
				data.get().setProducts(update);
				categoryRepository.save(data.get());
				return ResponseEntity.status(HttpStatus.OK).body("category update sucessfully!");
			}
			return ResponseEntity.status(HttpStatus.OK).body("category does not Exist");
			}
			catch(Exception e) {
				LOGGER.info("get by category Id error msg {} :",e.getMessage());
				return ResponseEntity.status(HttpStatus.OK).body("Please try after sometime!");
			}
	}
}
