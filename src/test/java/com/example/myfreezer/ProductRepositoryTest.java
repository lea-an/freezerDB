package com.example.myfreezer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.myfreezer.domain.Category;
import com.example.myfreezer.domain.Product;
import com.example.myfreezer.domain.ProductRepository;



@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)

public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    public void findByNameShouldReturnProduct() {
        List<Product> products = repository.findByName("Mansikat");
        
        assertThat(products).hasSize(1);
        assertThat(products.get(0).getCategory().getName()).isEqualTo("Marjat");
    }
    
    @Test
    public void createNewProduct() {
    	Product product = new Product(1, "2018-10-12", "2020-10-02","mustikat", 3);
    	repository.save(product);
    	assertThat(product.getId()).isNotNull();
    }    

}
