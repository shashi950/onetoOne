package com.OneToOne.Model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="product")
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	@Column(nullable = false)
	private String name ;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private BigDecimal price ;
	private Long categoryId;
	private Date createdAt ;
	private Date updatedAt ;
	
	 @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinColumn(name = "category_ids", nullable = false)
	    private Category category;
}
