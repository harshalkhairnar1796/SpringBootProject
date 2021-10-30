package org.nilesh.springbootcrudoperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
public class SalesController {
	
	@Autowired 
	  private SalesServices salesService;
	
	 @GetMapping("/")
	   public String welCome() {
		  return "WelCome to Sales Service "; 
	   }
	  
	  @PostMapping("/create")
	  public String create(@RequestBody Sales sales) {
		  Sales l=salesService.createSales(sales); 
	  return "Created Successfully"; }
	  
	  
	  @GetMapping("/getAll") 
	  public List<Sales> listOfSales() {
	  
	  return salesService.listOfSales(); }
}
