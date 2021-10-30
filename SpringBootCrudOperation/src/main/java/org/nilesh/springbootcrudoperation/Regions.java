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
@Table(name = "region")

public class Regions {
@Id	  //makes it primary key
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer regionsId;

private String name;

public Regions() {
	super();
}

public Integer getRegionsId() {
	return regionsId;
}

public void setRegionsId(Integer regionsId) {
	this.regionsId = regionsId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@Override
public int hashCode() {
	return Objects.hash(name, regionsId);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Regions other = (Regions) obj;
	return Objects.equals(name, other.name) && Objects.equals(regionsId, other.regionsId);
}

@Override
public String toString() {
	return "Regions [regionsId=" + regionsId + ", name=" + name + "]";
}



}
