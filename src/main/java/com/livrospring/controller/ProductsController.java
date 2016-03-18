package com.livrospring.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.livrospring.dao.ProductDAO;
import com.livrospring.model.BookType;
import com.livrospring.model.Product;
import com.livrospring.upload.FileSaver;

@Controller
@Transactional
@RequestMapping("/produtos")
public class ProductsController {
	
	@Autowired
	private ProductDAO productDao;
	@Autowired
	private FileSaver fileSaver;

	@RequestMapping("/form")
	public ModelAndView form(Product product){
		ModelAndView mav = new ModelAndView("/products/form");
		mav.addObject("types",BookType.values());
		
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView save(MultipartFile summary,@Valid Product product, BindingResult bindingResult,RedirectAttributes redirectAttributes){
		
		if(bindingResult.hasErrors()){
			return form(product);
		}
		String webpath = fileSaver.write("uploaded-images",summary);
		product.setSummaryPath(webpath);
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