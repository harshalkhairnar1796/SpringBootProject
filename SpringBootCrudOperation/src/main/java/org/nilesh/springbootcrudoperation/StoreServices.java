package org.nilesh.springbootcrudoperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class StoreServices {
	@Autowired
    private StoreDao repository;
    
    public Store createStore(Store Store) {
        return repository.save(Store);
    }
    public List<Store> listOfStore() {
        return repository.findAll();
    }
}
