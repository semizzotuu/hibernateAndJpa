package com.javacourse.project.hibernateAndJpa.Bussiness;

import java.util.List;

import com.javacourse.project.hibernateAndJpa.Entities.City;

public interface ICityService {
	List<City> getAll();//imzalar değişeceği için farklı bir interface içinde iş kodları kullandık
	
	void add(City city);
	void update(City city);
	void delete(City city);
	City getById(int id);

}
