package com.OneToOne.Controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.OneToOne.Exception.CommonException;
import com.OneToOne.IService.ProductIService;
import com.OneToOne.Model.Product;


@RequestMapping("/api/v1.0/product")
@RestController
public class ProductController {
	private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
@Autowired
private ProductIService productIService;

@RequestMapping(value="/save",method=RequestMethod.POST)
public Product saveProduct(@RequestBody Product dto) {
	Product data=productIService.saveProduct(dto);
	return data;
}

@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
public Product getProductById(@PathVariable Long id) {
	Product data=productIService.getProductById(id);
	return data;
}
@RequestMapping(value="/getAll",method=RequestMethod.GET)
public List<Product> getProductsList() {
	List<Product> data=productIService.getProductsList();
	return data;
}
@RequestMapping(value="/update/{id}",method=RequestMethod.PUT)
public Product UpdateProductById(@RequestBody Product dto,@PathVariable Long id) {
	Product data=productIService.UpdateProductById(dto,id);
	return data;
}
@RequestMapping(value="/remove/{id}",method=RequestMethod.DELETE)
public String DeleteProductById(@PathVariable Long id) {
	String  data=productIService.DeleteProductById(id);
	return data;
}
@ExceptionHandler
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public String getCommonException(CommonException ex) {
	LOGGER.error("Handling error with message: {}", ex.getMessage());
	
	return ex.getMessage();
}
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public String getException(Exception ex) {
	LOGGER.error("Handling error with message: {}", ex.getMessage());
	
	return ex.getMessage();
}
}
