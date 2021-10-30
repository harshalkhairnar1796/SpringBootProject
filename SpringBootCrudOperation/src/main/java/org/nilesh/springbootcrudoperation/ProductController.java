package org.nilesh.springbootcrudoperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired 
	  private ProductServices productService;
	@Autowired 
	  private ProductDao productRepo;
	
	 @GetMapping("/welcome")
	   public String welCome() {
		  return "WelCome to product Service "; 
	   }
	  
	  @PostMapping("/create")
	  public String create(@RequestBody Products product) {
		  Products l=productService.createProducts(product); 
	  return "Created Successfully"; }
	  
	  
	  @GetMapping("/getAll") 
	  public List<Products> listOfProducts() {
	  
	  return productService.listOfProducts(); }
	  
	  
	  
	  
	  @GetMapping("/add") //method path for product add
	  public String processRegister(Products user) {
		  
		  user.setColor(user.getColor());
		  user.setFullDescription(user.getFullDescription());
		  user.setName(user.getName());
		  user.setShortDescription(user.getFullDescription());
		  user.setSize(user.getSize());
	    
		productRepo.save(user);//save the values inside the product table
	       
	      return "prodreg"; //return the proreg page
	  }
	  
	  
	  @GetMapping("/list")    //method path
	  public String listUsers(Model model) {//getting the list of users
	      List<Products> listUsers = productRepo.findAll();
	      model.addAttribute("listUsers", listUsers);
	       
	      return "prodlist";   //return product
	  }
	  
	  
	  
	  
	  
	  
	  
	  
}
