package com.javacourse.project.hibernateAndJpa.DataAccess;
import com.javacourse.project.hibernateAndJpa.Entities.City;
import java.util.*;

public interface ICityDal {
	List<City> getAll();//bütün şehirleri listeliyecek list
	void add(City city);
	void update(City city);
	void delete(City city);
	City getById(int id);
	
 
}
