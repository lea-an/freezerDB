package com.example.myfreezer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.myfreezer.domain.Category;
import com.example.myfreezer.domain.CategoryRepository;
import com.example.myfreezer.domain.Product;
import com.example.myfreezer.domain.ProductRepository;
import com.example.myfreezer.domain.User;
import com.example.myfreezer.domain.UserRepository;




@SpringBootApplication
public class MyfreezerApplication {
	private static final Logger log = LoggerFactory.getLogger(MyfreezerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MyfreezerApplication.class, args);
	}

	@Bean
	public CommandLineRunner studentDemo(ProductRepository prepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of products");
			crepository.save(new Category("Marjat"));
			crepository.save(new Category("Välipala"));
			crepository.save(new Category("Ruoka"));
			
			prepository.save(new Product("Mansikka", "2019-11-04", "2020-02-04", 3, crepository.findByName("Marjat").get(0)));
			prepository.save(new Product("Maksalaatikko", "2019-10-10", "2020-02-10", 2, crepository.findByName("Ruoka").get(0)));	
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$10$zxPl2U8FBIJcvo/urKZVqOGCgeIz0FLN1v8LEOgbT7RdFEW7boGBW", "USER");
			User user2 = new User("admin", "$2a$10$B9RXEpy0tKunJXu3hp4S4OnazDbsdtcRYAMuWaqn1694JJumqWY7O", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all products");
			for (Product product : prepository.findAll()) {
				log.info(product.toString());
			}

		};
	}
}
