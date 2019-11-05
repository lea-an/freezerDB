package com.example.myfreezer.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.myfreezer.domain.CategoryRepository;
import com.example.myfreezer.domain.Product;
import com.example.myfreezer.domain.ProductRepository;


@Controller
public class FreezerController {
	
	@Autowired 
	private ProductRepository pRepository;
	@Autowired
	private CategoryRepository cRepository;
	
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	

	//kaikki pakastimen tuotteet listaus
	@GetMapping("productlist")
	public String index (Model model) {
		System.out.println("controller.productlist");
		model.addAttribute("products", pRepository.findAll());
		return "productlist";
	}

	
	//lisää tuote
	@GetMapping("add")
	public String addProduct(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("categories", cRepository.findAll());
		return "addProduct";
	}
	
	//tallenna tuote
	@PostMapping("save")
	public String saveProduct(Product product) {
		pRepository.save(product);
		return "redirect:productlist";
	}
	//muokkaa valitun tuotteen tietoja
    @GetMapping(value = "/edit/{id}")
    public String updateProduct(@PathVariable("id") Long id, Model model) {
    	Product product = pRepository.findById(id).get();
    	System.out.println("update product " + product.toString());
    	model.addAttribute("product", product);
    	model.addAttribute("categories", cRepository.findAll());
    	return "editProduct";
    }

	//Luetaan polkumuuttujasta tuhottavan tuotteen id
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id") Long id, Model model) {
    	System.out.println("product "  + id);

    	//Crudrepository-luokan valmis metodi
    	pRepository.deleteById(id);
    	return "redirect:../productlist";
    }


}
