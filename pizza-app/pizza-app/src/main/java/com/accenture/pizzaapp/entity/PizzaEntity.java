package com.accenture.pizzaapp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pizza")
public class PizzaEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pizzaId;
	private String pizzaName;
	private Double pizzaPrice;
	private char pizzaType;
	private Date useByDate;
	
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
		return "\nPizzaEntity [pizzaId=" + pizzaId + ", pizzaName=" + pizzaName + ", pizzaPrice=" + pizzaPrice
				+ ", pizzaType=" + pizzaType + ", useByDate=" + useByDate + "]";
	}
	
}
