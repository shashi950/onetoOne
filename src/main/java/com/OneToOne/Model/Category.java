package com.OneToOne.Model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="category")
public class Category {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	@Column(nullable = false)
	private String name ;
	private String description;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<Product>();

}
