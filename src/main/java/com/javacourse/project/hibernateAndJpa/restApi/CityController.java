package com.javacourse.project.hibernateAndJpa.restApi;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacourse.project.hibernateAndJpa.Bussiness.ICityService;
import com.javacourse.project.hibernateAndJpa.Entities.*;


@RestController
@RequestMapping("/api")
public class CityController {
	
	private ICityService cityService;
	
	@Autowired
	public CityController(ICityService cityService) {
		
		this.cityService = cityService;
	}
	@GetMapping("/cities")
	public List<City> get(){
		return cityService.getAll();
		
	}
	@PostMapping("/add")
	public void add(@RequestBody City city) {
		cityService.add(city);
	}
	@PostMapping("/update")
	public void update(@RequestBody City city) {
		cityService.update(city);
	}
	@PostMapping("/delete")
	public void delete(@RequestBody City city) {
		cityService.delete(city);
	}
	@GetMapping("/cities/{id}")//getirilecek olan datanın id sini zorunlu olarak istiyoruz örneğin"/cities/125" 125 inci id
	public City getById(@PathVariable int id){//bu yoldan bize id yi oku
		return cityService.getById(id);
		
		
		
	}

}
