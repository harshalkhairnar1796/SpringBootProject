package org.nilesh.springbootcrudoperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
	@Autowired 
	  private CurrenciesService currenciesServices;
	  
	  @GetMapping("/")
	   public String welCome() {
		  return "WelCome to Currencies Service "; 
	   }
	  
	  @PostMapping("/create")
	  public String create(@RequestBody Currencies currencies) {
		  Currencies l=currenciesServices.createCurrencies(currencies); 
	  return "Created Successfully"; }
	  
	  
	  @GetMapping("/getAll") 
	  public List<Currencies> listOfCurrencies() {
	  
	  return currenciesServices.listOfCurrencies(); }
}
