package org.nilesh.springbootcrudoperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class CurrenciesService {
	@Autowired
    private CurrencyDao repository;
    
    public Currencies createCurrencies(Currencies currencies) {
        return repository.save(currencies);
    }
    public List<Currencies> listOfCurrencies() {
        return repository.findAll();
    }
}
