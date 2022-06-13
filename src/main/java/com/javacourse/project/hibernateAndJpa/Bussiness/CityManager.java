package com.javacourse.project.hibernateAndJpa.Bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javacourse.project.hibernateAndJpa.DataAccess.ICityDal;
import com.javacourse.project.hibernateAndJpa.Entities.City;

@Service //bu bir iş katmanıdır dediğimiz kod.
public class CityManager implements ICityService {
	
	private ICityDal cityDal;
	
	@Autowired
	public CityManager(ICityDal cityDal) {
		this.cityDal = cityDal;
	}

	@Override
	@Transactional//bussinessin transactionalı 
	public List<City> getAll() {
		return this.cityDal.getAll();
	}

	@Override
	@Transactional
	public void add(City city) {
		//gönderilen şehirleri kontrol edebileceğimiz iş kurallarını yazıyoruz.
		this.cityDal.add(city);
		
	}

	@Override
	@Transactional
	public void update(City city) {
		this.cityDal.update(city);
		
	}

	@Override
	@Transactional
	public void delete(City city) {
		this.cityDal.delete(city);
		
	}

	@Override
	public City getById(int id) {
		return this.cityDal.getById(id);
	}

}
