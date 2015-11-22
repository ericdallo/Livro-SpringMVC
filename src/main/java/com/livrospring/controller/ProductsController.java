package com.livrospring.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.livrospring.dao.ProductDAO;
import com.livrospring.model.BookType;
import com.livrospring.model.Product;

@Controller
@Transactional
@RequestMapping("/produtos")
public class ProductsController {
	
	@Autowired
	private ProductDAO productDao;

	@RequestMapping("/form")
	public ModelAndView form(){
		ModelAndView mav = new ModelAndView("/products/form");
		mav.addObject("types",BookType.values());
		
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String save(Product product, RedirectAttributes redirectAttributes){
		productDao.save(product);
		
		redirectAttributes.addFlashAttribute("success","Produto cadastrado com sucesso");
		return "redirect:produtos";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView list(Product product){
		ModelAndView mav = new ModelAndView("/products/list");
		mav.addObject("products",productDao.list());
		
		return mav;
	}
	
	
}
