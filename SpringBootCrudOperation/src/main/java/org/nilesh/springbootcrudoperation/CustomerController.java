package org.nilesh.springbootcrudoperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //Class makes as a controller
@RequestMapping("/customer") // define rest path
public class CustomerController {
	@Autowired //injecting CustomerService Dependency
	  private CustomersServices customersServices;
	
	@Autowired ////injecting CustomerDao Dependency
	  private CustomerDao customeRepo;
	 @GetMapping("/welcome")
	   public String welCome() {
		  return "WelCome to Customer Service "; 
	   }
		/*
		 * @GetMapping("/login") public String loginPage() { return "login"; }
		 */
	 
		
		/*
		 * @GetMapping("/login") public String registerPage( Model model) {
		 * model.addAttribute("customer",new Customers()); return "login"; }
		 */
		 
	  @PostMapping("/create")//define method path
	  public String create(@RequestBody Customers customers) {
		  Customers l=customersServices.createCustomers(customers); //calling the create method in customer service
	  return "Created Successfully"; } //return the status message
	  
	  
	  @GetMapping("/getAll") //getting all recoards from customers Entity
	  public List<Customers> listOfCurrencies() {
	  
	  return customersServices.listOfCustomers(); }
	  
	  
	  @GetMapping("/users")    //method path
	  public String listUsers(Model model) {//getting the list of users
	      List<Customers> listUsers = customeRepo.findAll();
	      model.addAttribute("listUsers", listUsers);
	       
	      return "users";   //return users
	  }
	  
	  
	  @GetMapping("")
	    public String viewHomePage() {// rest call for index page
	        return "index"; //retun index page
	    }
	  
		
		  @GetMapping("/register") //Register url path
		  public String showRegistrationForm(Model model) {
		  model.addAttribute("user", new Customers());  //adding the for data
		  
		  return "signup_form"; }  // return the signup form
		 
	  
	  @GetMapping("/login")
	  public String loginData() {	    //rest call for login   
	      return "login";  //return login page
	  }
	  
	  
	  
	  
	  @GetMapping("/process_register") //method path for registation process
	  public String processRegister(Customers user) {
		  
		user.setFirstName(user.getFirstName()); //getting the form values and set those
		user.setEmail(user.getEmail());         //values to customer object
		user.setLastName(user.getLastName());
		user.setPhoneNumber(user.getPhoneNumber());
		
		  Countries cou = new Countries(); 
		  cou.setName(user.getCname());
		  user.setCountry(cou);
		 
		/*
		 * // String encodedPassword =user.getFirstName(); // BCryptPasswordEncoder
		 * passwordEncoder = new BCryptPasswordEncoder(); // String encodedPassword =
		 * passwordEncoder.encode(user.getPassword());
		 * //user.setPassword(encodedPassword);
		 */	      
	      user.setPassword(user.getPassword());
	     
	      customeRepo.save(user);//save the values inside the customer table
	       
	      return "reg"; //return the reg page
	  }
	  
	  @GetMapping("/checkdata")
	  public String checkData(Customers user,Model model) {    //used to check user data
		Customers cust=customeRepo.findByFirstName(user.getFirstName());
		
		if(cust!=null) { //checking customer object
			if(cust.getPassword().equals(user.getPassword())) {//checking password
			//String firstName=cust.getFirstName();
			model.addAttribute("user", cust);
			return "success";  //return the success page
			}		 
		} 
		return "failure";       //return failure page
	      
	  }
	     
	  @GetMapping("/logout")
	  public String logoutData() {	    //rest call for logout   
	      return "logout";  //return logout page
	  }
	  
	  	
		/*
		 * @GetMapping("/edit/{firstName}") //Register url path public String
		 * showEditForm(@PathVariable(name = "firstName") String firstName) { Customers
		 * customers = customeRepo.findByFirstName(firstName);
		 * model.addAttribute("user", new Customers()); //adding the for data return
		 * "editform"; }
		 */
		
		/*
		 * @PostMapping("/save_data") public String registeruser(@ModelAttribute("user")
		 * Customers user) { customeRepo.save(user); return "redirect:/"; }
		 */
		  
		
	      @GetMapping("/edit/{firstName}")
		  public String showEditProductPage(@PathVariable(name = "firstName") String firstName,
				  Model mav)
		  { 
		  Customers customers = customeRepo.findByFirstName(firstName);
		  //customeRepo.delete(customers);
		  mav.addAttribute("user", customers); 
		  return "editform"; 
		  }
		  
		  
			
			  @GetMapping("/process_edit") //method path for registation process public String
			  public String processEdit(Customers user) {
			  
				  Customers cust=customeRepo.findByFirstName(user.getFirstName());
			      cust.setFirstName(user.getFirstName()); //getting the form values and set
			      cust.setPassword(user.getPassword());
				  cust.setEmail(user.getEmail()); //values to customer object
				  cust.setLastName(user.getLastName());
				  cust.setPhoneNumber(user.getPhoneNumber());
			  
			  Countries cou = new Countries(); 
			  cou.setName(user.getCname());
			  cust.setCountry(cou);
			  cust.setPassword(user.getPassword());
			  customeRepo.save(cust);//save the values inside the customer table
			  
			  return "editreg"; //return the reg page 
			  }
			 		 
		 
			  
			  @GetMapping("/delete/{firstName}")
			  public String deleteCustomer(@PathVariable(name = "firstName") String firstName,
					  Model mav)
			  { 
			  Customers customers = customeRepo.findByFirstName(firstName);
			  customeRepo.delete(customers);
			  //mav.addAttribute("user", customers); 
			  return "deleteform"; 
			  }
	  
}
