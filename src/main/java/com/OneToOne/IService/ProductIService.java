package com.OneToOne.IService;

import java.util.List;

import com.OneToOne.Model.Product;

public interface ProductIService {

	Product getProductById(Long id);

	List<Product> getProductsList();

	Product UpdateProductById(Product dto, Long id);

	Product saveProduct(Product dto);

	String DeleteProductById(Long id);

}
