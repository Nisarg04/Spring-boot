package com.accenture.pizzaapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.pizzaapp.beans.Pizza;
import com.accenture.pizzaapp.services.PizzaServiceImpl;

@RestController
@RequestMapping(value="pizza")
public class PizzaController {

	@Autowired
	private PizzaServiceImpl pizzaService;
	
	@RequestMapping(value="getAllPizzas", 
			method=RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pizza>> getAllPizzas() {
		List<Pizza> pizzas = pizzaService.getAllPizzas();
		return new ResponseEntity<>(pizzas, HttpStatus.OK);
	}
	
	@RequestMapping(value="addPizza", 
			method=RequestMethod.POST, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addPizza(@Valid @RequestBody Pizza pizza) {
		int addedPizzaId = pizzaService.addPizza(pizza);
		return new ResponseEntity<>("Added pizza with id : " + addedPizzaId, HttpStatus.OK);
	}
	
	@RequestMapping(value="getPizzaById/{id}",
			method=RequestMethod.PUT,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pizza> getPizzaById(@PathVariable int id) {
		Pizza pizza = pizzaService.getPizzaById(id);
		return new ResponseEntity<>(pizza, HttpStatus.OK);
	}
	
	@RequestMapping(value="updatePizza",
			method=RequestMethod.PUT,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updatePizzaById(@RequestBody Pizza pizza) {
		Pizza updatedPizza = pizzaService.updatePizzaById(pizza);
		return new ResponseEntity<>("Pizza updated with id : " + updatedPizza.getPizzaId(), HttpStatus.OK);
	}
	
	@RequestMapping(value="deletePizza", 
			method=RequestMethod.DELETE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deletePizza(@RequestBody Pizza pizza) {
		Pizza deletedPizza = pizzaService.deletePizza(pizza.getPizzaId());
		return new ResponseEntity<>("Pizza deleted with id : " + deletedPizza.getPizzaId(), HttpStatus.OK);
	}
	
	@RequestMapping(value="deletePizzaById/{pizzaId}", 
			method=RequestMethod.DELETE)
	public ResponseEntity<String> deletePizzaById(@PathVariable int pizzaId) {
		Pizza deletedPizza = pizzaService.deletePizza(pizzaId);
		return new ResponseEntity<>("Pizza deleted with id : " + deletedPizza.getPizzaId(), HttpStatus.OK);
	}
	
	@RequestMapping(value="getPizzaMoreThanPrice/{price}",
			method=RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pizza>> getPizzaMoreThan(@PathVariable double price) {
		List<Pizza> result = pizzaService.getPizzaMoreThan(price);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
