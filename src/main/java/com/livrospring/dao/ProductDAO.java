package com.livrospring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.livrospring.model.Product;

@Repository
public class ProductDAO {
	
	@PersistenceContext
	private EntityManager manager;

	public void save(Product product) {
		manager.persist(product);
	}

	public List<Product> list() {
		return manager
						.createQuery("SELECT distinct(p) FROM Product p join fetch p.prices",Product.class)
						.getResultList();
	}
	
}
