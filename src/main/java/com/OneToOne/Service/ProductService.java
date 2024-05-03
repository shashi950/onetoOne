package com.OneToOne.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OneToOne.Exception.CommonException;
import com.OneToOne.IService.ProductIService;
import com.OneToOne.Model.Product;
import com.OneToOne.Repository.ProductRepository;
@Service 
public class ProductService implements  ProductIService{
	private final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
@Autowired
private ProductRepository productRepository;

@Override
public Product saveProduct(Product dto) {
	try {
		LOGGER.info("Product data is {} :",dto);
		
			Date date=new Date();
			dto.setCreatedAt(date);
			productRepository.save(dto);
		return dto;
		}
		
		catch(Exception e) {
			LOGGER.info("get byProduct Id error msg {} :",e.getMessage());
			throw new CommonException("Please try after  some times!");
		}
}
@Override
public Product getProductById(Long id) {
	try {
	LOGGER.info("Product Id is {} :",id);
	Optional<Product> data=productRepository.findById(id);
	if(data.get()!=null) {
	return data.get();
	}
	throw new CommonException("Product id does not Exist");
	}
	catch(Exception e) {
		LOGGER.info("get byProduct Id error msg {} :",e.getMessage());
		throw new CommonException("Please try after  some times!");
	}
}
@Override
public List<Product> getProductsList() {
	try {
		List<Product> data=productRepository.findAll();
		if(data.size()!=0) {
		return data;
		}
		throw new CommonException("Products does not Exist");
		}
	catch(CommonException e) {
		LOGGER.info("get byProduct Id error msg {} :",e.getMessage());
		throw new CommonException(e.getMessage());
	}
		catch(Exception e) {
			LOGGER.info("get byProduct Id error msg {} :",e.getMessage());
			throw new CommonException("Please try after  some times!");
		}
}
@Override
public Product UpdateProductById(Product dto, Long id) {
	try {
		LOGGER.info("Product Id is {} :",id);
		Optional<Product> data=productRepository.findById(id);
		if(data.get()!=null) {
			Date date=new Date();
			Product updateData=data.get();
			updateData.setDescription(dto.getDescription());
			updateData.setName(dto.getName());
			updateData.setPrice(dto.getPrice());
			updateData.setUpdatedAt(date);
			productRepository.save(updateData);
		return updateData;
		}
		throw new CommonException("Product id does not Exist");
		}
	catch(CommonException e) {
		LOGGER.info("get byProduct Id error msg {} :",e.getMessage());
		throw new CommonException(e.getMessage());
	}
		catch(Exception e) {
			LOGGER.info("get byProduct Id error msg {} :",e.getMessage());
			throw new CommonException("Please try after  some times!");
		}
}
@Override
public String DeleteProductById(Long id) {
	try {
		LOGGER.info("Product Id is {} :",id);
		Optional<Product> data=productRepository.findById(id);
		if(data.get()!=null) {
			productRepository.delete(data.get());
		return "prodcut removed succussfully! with Id "+id;
		}
		throw new CommonException("Product id does not Exist");
		}
		catch(Exception e) {
			LOGGER.info("get byProduct Id error msg {} :",e.getMessage());
			throw new CommonException("Please try after  some times!");
		}
}

}
