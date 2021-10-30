package org.nilesh.springbootcrudoperation;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity //class makes as a entity
@Table(name = "currencies")
public class Currencies {

	@Id	  //makes it primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer currencyId;

	private String name;
	
	
	@OneToMany(cascade = CascadeType.ALL)
    private List<Countries> countries;
	 

	public Currencies() {
		super();
	}

	public Integer getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	  public List<Countries> getCountries() 
	  { return countries; }
	  
	  public void setCountries(List<Countries> countries)
	  { this.countries = countries; }
	 

	@Override
	public int hashCode() {
		return Objects.hash( currencyId, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Currencies other = (Currencies) obj;
		return Objects.equals(currencyId, other.currencyId)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Currencies [currencyId=" + currencyId + ", name=" + name +  "]";
	}
	
	
	
}
