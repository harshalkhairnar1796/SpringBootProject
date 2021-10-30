package org.nilesh.springbootcrudoperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CountryServices {
	@Autowired
    private CountryDao repository;
    
    public Countries createCountries(Countries countries) {
        return repository.save(countries);
    }
    public List<Countries> listOfCountries() {
        return repository.findAll();
    }
}
