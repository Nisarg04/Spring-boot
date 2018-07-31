package com.accenture.pizzaapp.beans;

import java.util.Date;

import org.hibernate.validator.constraints.Range;

public class Pizza {
	
	private Integer pizzaId;
	private String pizzaName;
	
	@Range(min=500, max=2000, message="Prixw should be in range") 
	private Double pizzaPrice;

	private char pizzaType;
	private Date useByDate;
	
	public Pizza() {}
	
	public Pizza(int pizzaId, String pizzaName, Double pizzaPrice, char pizzaType, Date useByDate) {
		super();
		this.pizzaId = pizzaId;
		this.pizzaName = pizzaName;
		this.pizzaPrice = pizzaPrice;
		this.pizzaType = pizzaType;
		this.useByDate = useByDate;
	}
	
	public int getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public Double getPizzaPrice() {
		return pizzaPrice;
	}
	public void setPizzaPrice(Double pizzaPrice) {
		this.pizzaPrice = pizzaPrice;
	}
	public char getPizzaType() {
		return pizzaType;
	}
	public void setPizzaType(char pizzaType) {
		this.pizzaType = pizzaType;
	}
	public Date getUseByDate() {
		return useByDate;
	}
	public void setUseByDate(Date useByDate) {
		this.useByDate = useByDate;
	}
	
	@Override
	public String toString() {
		return "\nPizza [pizzaId=" + pizzaId + ", pizzaName=" + pizzaName + ", pizzaPrice=" + pizzaPrice + ", pizzaType="
				+ pizzaType + ", useByDate=" + useByDate + "]";
	}
	
	
}
