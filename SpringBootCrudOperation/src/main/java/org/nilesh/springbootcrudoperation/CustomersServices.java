package org.nilesh.springbootcrudoperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service  //class makes as a Service
public class CustomersServices {
	@Autowired //injecting CustomerDao dependency
    private CustomerDao repository;
    
    public Customers createCustomers(Customers customers) {//implementing creating method
        return repository.save(customers); //calling repository method
    }
    public List<Customers> listOfCustomers() { //getting the all customers details
        return repository.findAll();//calling the dao findAll method
    }
}
