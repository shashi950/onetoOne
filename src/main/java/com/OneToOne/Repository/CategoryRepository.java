package com.OneToOne.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OneToOne.Model.Category;


public interface CategoryRepository extends JpaRepository<Category,Long> {

}
