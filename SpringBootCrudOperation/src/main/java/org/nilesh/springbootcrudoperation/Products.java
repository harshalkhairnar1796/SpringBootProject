package org.nilesh.springbootcrudoperation;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //class makes as a entity
@Table(name = "products")
public class Products {
	@Id	  //makes it primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	private String name;
	private String shortDescription; 
	private String fullDescription;
	private String size; 
	private String color;
	
	
	public Products() {
		super();
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getFullDescription() {
		return fullDescription;
	}
	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public int hashCode() {
		return Objects.hash(color, fullDescription, name, productId, shortDescription, size);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		return Objects.equals(color, other.color) && Objects.equals(fullDescription, other.fullDescription)
				&& Objects.equals(name, other.name) && Objects.equals(productId, other.productId)
				&& Objects.equals(shortDescription, other.shortDescription) && Objects.equals(size, other.size);
	}
	@Override
	public String toString() {
		return "Products [productId=" + productId + ", name=" + name + ", shortDescription=" + shortDescription
				+ ", fullDescription=" + fullDescription + ", size=" + size + ", color=" + color + "]";
	}
	
	
	
}
