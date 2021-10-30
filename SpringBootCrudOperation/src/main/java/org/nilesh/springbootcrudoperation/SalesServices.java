package org.nilesh.springbootcrudoperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class SalesServices {
	@Autowired
    private SalesDao repository;
    
    public Sales createSales(Sales Sales) {
        return repository.save(Sales);
    }
    public List<Sales> listOfSales() {
        return repository.findAll();
    }
}
