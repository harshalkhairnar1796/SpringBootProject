package org.nilesh.springbootcrudoperation;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity //class makes as a entity
@Table(name = "customer") //create table name
public class Customers {
	@Id	  //makes it primary key
	@GeneratedValue(strategy = GenerationType.AUTO) //generating the sequence table values
	private Integer customerId;

	private String firstName; // declaring field names
	private String lastName;
	private String email;
	private String phoneNumber;
	private String password;
	@Transient
	private String cname;
	
	
	@OneToOne(cascade = CascadeType.ALL) // mapped with Country
	private Countries country;


	public Customers() {  //generating default constructor
		super();
	}


	public Integer getCustomerId() {  //generating getters and setters methods 
		return customerId;
	}                                          //for variables


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Countries getCountry() {
		return country;
	}


	public void setCountry(Countries country) {
		this.country = country;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	@Override                   // Override the hash code method
	public int hashCode() {
		return Objects.hash(country, customerId, email, firstName, lastName, password, phoneNumber);
	}


	@Override                               //override the Equal methods
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customers other = (Customers) obj;
		return Objects.equals(country, other.country) && Objects.equals(customerId, other.customerId)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(phoneNumber, other.phoneNumber);
	}


	@Override
	public String toString() {      //override the to string methods
		return "Customers [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", password=" + password + ", country="
				+ country + "]";
	}

	
	
	
	
}
