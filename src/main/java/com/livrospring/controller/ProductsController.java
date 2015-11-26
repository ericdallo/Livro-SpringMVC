package com.livrospring.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.livrospring.dao.ProductDAO;
import com.livrospring.model.BookType;
import com.livrospring.model.Product;
import com.livrospring.validation.ProductValidator;

@Controller
@Transactional
@RequestMapping("/produtos")
public class ProductsController {
	
	
	/* não necessario pelo @NotBlank
	@InitBinder
	public void before(WebDataBinder binder){
		binder.setValidator(new ProductValidator());
	}*/
	
	@Autowired
	private ProductDAO productDao;

	@RequestMapping("/form")
	public ModelAndView form(Product product){
		ModelAndView mav = new ModelAndView("/products/form");
		mav.addObject("types",BookType.values());
		
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView save(@Valid Product product, BindingResult bindingResult,RedirectAttributes redirectAttributes){
		
		if(bindingResult.hasErrors()){
			return form(product);
		}
		
		productDao.save(product);
		
		redirectAttributes.addFlashAttribute("success","Produto cadastrado com sucesso");
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView list(Product product){
		ModelAndView mav = new ModelAndView("/products/list");
		mav.addObject("products",productDao.list());
		
		return mav;
	}
	
	
}
