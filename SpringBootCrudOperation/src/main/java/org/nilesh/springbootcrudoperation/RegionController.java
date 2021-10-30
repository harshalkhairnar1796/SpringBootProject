package org.nilesh.springbootcrudoperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/region")
public class RegionController {
	@Autowired 
	  private RegionService regionServices;
	
	 @GetMapping("/")
	   public String welCome() {
		  return "WelCome to Regions Service "; 
	   }
	  
	  @PostMapping("/create")
	  public String create(@RequestBody Regions regions) {
		  Regions l=regionServices.createRegions(regions); 
	  return "Created Successfully"; }
	  
	  
	  @GetMapping("/getAll") 
	  public List<Regions> listOfRegions() {
	  
	  return regionServices.listOfRegions(); }
}
