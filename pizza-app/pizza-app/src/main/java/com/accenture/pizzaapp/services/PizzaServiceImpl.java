package com.accenture.pizzaapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.pizzaapp.beans.Pizza;
import com.accenture.pizzaapp.dao.PizzaDAO;
import com.accenture.pizzaapp.entity.PizzaEntity;

@Service
public class PizzaServiceImpl {
	
	@Autowired
	private PizzaDAO pizzaDAO;

	public List<Pizza> getAllPizzas() {
		List<PizzaEntity> pizzas = pizzaDAO.findAll();
		List<Pizza> listOfPizza = new ArrayList<>();
		pizzas.forEach(i -> {
			Pizza pizza = new Pizza();
			BeanUtils.copyProperties(i, pizza);
			listOfPizza.add(pizza);
		});
		return listOfPizza;
	}

	public int addPizza(Pizza pizza) {
		PizzaEntity pizzaEntity = new PizzaEntity();
		BeanUtils.copyProperties(pizza, pizzaEntity);
		PizzaEntity addedPizza = pizzaDAO.save(pizzaEntity);
		return addedPizza.getPizzaId();
	}

	public Pizza getPizzaById(int id) {
		PizzaEntity pizzaEntity = pizzaDAO.getOne(id);
		Pizza pizza = new Pizza();
		BeanUtils.copyProperties(pizzaEntity, pizza);
		return pizza;
	}

	public Pizza updatePizzaById(Pizza pizza) {
		PizzaEntity pizzaEntity = pizzaDAO.getOne(pizza.getPizzaId());
		BeanUtils.copyProperties(pizza, pizzaEntity);
		pizzaDAO.save(pizzaEntity);
		return pizza;
	}

	public Pizza deletePizza(int pizzaId) {
		Pizza pizza = new Pizza();
		PizzaEntity pizzaEntity = pizzaDAO.getOne(pizzaId);
		pizzaDAO.delete(pizzaEntity);
		BeanUtils.copyProperties(pizzaEntity, pizza);
		return pizza;
	}

	public List<Pizza> getPizzaMoreThan(double price) {
		List<PizzaEntity> list = pizzaDAO.getAllVegPizzasBelow(price);
		List<Pizza> result = new ArrayList<>();
		list.forEach(i -> {
			Pizza p = new Pizza();
			BeanUtils.copyProperties(i, p);
			result.add(p);
		});
		return result;
	}

}
