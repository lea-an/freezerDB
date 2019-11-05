package com.example.myfreezer.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myfreezer.domain.CategoryRepository;
import com.example.myfreezer.domain.Product;
import com.example.myfreezer.domain.ProductRepository;



@RestController
public class RestFreezerController {

		@Autowired
		private ProductRepository pRepository;
		@Autowired
		private CategoryRepository cRepository;

		@RequestMapping(value="products", method = RequestMethod.GET)
		public List<Product> productListRest() {
			return (List<Product>) pRepository.findAll();
		}

		
		//Lisätään uusi tuote kantaan
		@RequestMapping(value="products", method = RequestMethod.POST)
		public List<Product> saveBook(@RequestBody Product product) {
			pRepository.save(product);
			return (List<Product>) pRepository.findAll();
		}
		
		// RESTful service to get product by id
	    @RequestMapping(value="/product/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Product> findProductRest(@PathVariable("id") Long productId) {	
	    	return pRepository.findById(productId);
	    }  
		
	}