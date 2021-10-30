package org.nilesh.springbootcrudoperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/country")
public class CountyController {
	@Autowired 
	  private CountryServices countryService;
	  
	  @GetMapping("/")
	   public String welCome() {
		  return "WelCome to Country Service "; 
	   }
	  
	  @PostMapping("/create")
	  public String create(@RequestBody Countries countries) {
		  Countries l=countryService.createCountries(countries); 
	  return "Created Successfully"; }
	  
	  
	  @GetMapping("/getAll") 
	  public List<Countries> listOfLaptop() {
	  
	  return countryService.listOfCountries(); }
}
