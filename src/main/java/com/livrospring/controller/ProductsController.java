package com.livrospring.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.livrospring.dao.ProductDAO;
import com.livrospring.model.Product;

@Controller
@Transactional
public class ProductsController {
	
	@Autowired
	private ProductDAO productDao;

	@RequestMapping("/produtos/form")
	public String form(){
		return "products/form";
	}
	
	@RequestMapping("/produtos")
	public String save(Product product){
		productDao.save(product);
		return "products/ok";
	}
}
