package com.accenture.pizzaapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.pizzaapp.entity.PizzaEntity;

public interface PizzaDAO extends JpaRepository<PizzaEntity, Integer> {
		@Query("select k from PizzaEntity k where k.pizzaPrice>=?1 and k.pizzaType='V'")
		List<PizzaEntity> getAllVegPizzasBelow(double price);
}