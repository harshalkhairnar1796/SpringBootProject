package org.nilesh.springbootcrudoperation;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity //class makes as a entity
@Table(name = "store")
public class Store {
	@Id	  //makes it primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer storeId;
	
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customers customer;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Countries country;

	public Store() {
		super();
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
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

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public Countries getCountry() {
		return country;
	}

	public void setCountry(Countries country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, customer, email, firstName, lastName, phoneNumber, storeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Store other = (Store) obj;
		return Objects.equals(country, other.country) && Objects.equals(customer, other.customer)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(storeId, other.storeId);
	}

	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", customer=" + customer + ", country=" + country + "]";
	}
	
	
}
