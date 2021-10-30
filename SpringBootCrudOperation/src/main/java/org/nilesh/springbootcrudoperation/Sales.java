package org.nilesh.springbootcrudoperation;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity //class makes as a entity
@Table(name = "sales")
public class Sales {
	@Id	  //makes it primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer salesId;
	
	private String salesChannels;
	private String orderNumber;
	
	private Double netAmount;
	private Double tax;
	private Double grossAmount;
	private Double shippingCost;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customers customer;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Currencies currency;
	
	@OneToMany(cascade = CascadeType.ALL) 
	private Set<Products> product;

	public Sales() {
		super();
	}

	public Integer getSalesId() {
		return salesId;
	}

	public void setSalesId(Integer salesId) {
		this.salesId = salesId;
	}

	public String getSalesChannels() {
		return salesChannels;
	}

	public void setSalesChannels(String salesChannels) {
		this.salesChannels = salesChannels;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(Double grossAmount) {
		this.grossAmount = grossAmount;
	}

	public Double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(Double shippingCost) {
		this.shippingCost = shippingCost;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public Currencies getCurrency() {
		return currency;
	}

	public void setCurrency(Currencies currency) {
		this.currency = currency;
	}

	public Set<Products> getProduct() {
		return product;
	}

	public void setProduct(Set<Products> product) {
		this.product = product;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(currency, customer, grossAmount, netAmount, orderNumber, product, salesChannels, salesId,
				shippingCost, tax);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sales other = (Sales) obj;
		return Objects.equals(currency, other.currency) && Objects.equals(customer, other.customer)
				&& Objects.equals(grossAmount, other.grossAmount) && Objects.equals(netAmount, other.netAmount)
				&& Objects.equals(orderNumber, other.orderNumber) && Objects.equals(product, other.product)
				&& Objects.equals(salesChannels, other.salesChannels) && Objects.equals(salesId, other.salesId)
				&& Objects.equals(shippingCost, other.shippingCost) && Objects.equals(tax, other.tax);
	}

	@Override
	public String toString() {
		return "Sales [salesId=" + salesId + ", salesChannels=" + salesChannels + ", orderNumber=" + orderNumber
				+ ", netAmount=" + netAmount + ", tax=" + tax + ", grossAmount=" + grossAmount + ", shippingCost="
				+ shippingCost + ", customer=" + customer + ", currency=" + currency + ", product=" + product + "]";
	}
	
	
	
}
