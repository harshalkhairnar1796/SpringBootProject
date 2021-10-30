package org.nilesh.springbootcrudoperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class ProductServices {
	@Autowired
    private ProductDao repository;
    
    public Products createProducts(Products products) {
        return repository.save(products);
    }
    public List<Products> listOfProducts() {
        return repository.findAll();
    }
}
