package com.OneToOne.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OneToOne.Model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

	Optional<Product> findById(Long id);

	List<Product> findByCategoryId(Long id);

}
