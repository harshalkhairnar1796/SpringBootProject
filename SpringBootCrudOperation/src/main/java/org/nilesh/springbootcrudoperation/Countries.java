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
@Table(name = "countries")
public class Countries {
	@Id	  //makes it primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer countryId;
	
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Regions region;

	public Countries() {
		super();
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Regions getRegion() {
		return region;
	}

	public void setRegion(Regions region) {
		this.region = region;
	}

	@Override
	public int hashCode() {
		return Objects.hash(countryId, name, region);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Countries other = (Countries) obj;
		return Objects.equals(countryId, other.countryId) && Objects.equals(name, other.name)
				&& Objects.equals(region, other.region);
	}

	@Override
	public String toString() {
		return "Countries [countryId=" + countryId + ", name=" + name + ", region=" + region + "]";
	}
	
	
	
}
