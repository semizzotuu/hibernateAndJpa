package com.javacourse.project.hibernateAndJpa.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javacourse.project.hibernateAndJpa.Entities.City;
@Repository

public class HibernateCityDal implements ICityDal{
//JPA - ORM  jpa implement ediliyor.
	
	private EntityManager entityManager;
	
	
	@Autowired//annoutation-hibernate injection gerçekleştirecek otomatik olarak.
	public HibernateCityDal(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	@Transactional //sessionun başında ve sonuna transection eklenmiş gibi çalışıyor.AOP Aspect Oriented Programing 
	public List<City> getAll() {//hibernate kodladık.
		Session session = entityManager.unwrap(Session.class);//bütün cityi datasını getirecek,unit of model 
		List<City> cities = session.createQuery("from City",City.class).getResultList();//query ile sorgu yapılacak yeri seçiyoruz.
		return cities;
	}

	@Override
	@Transactional
	public void add(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);
		
		
	}

	@Override
	@Transactional
	public void update(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);
		
	}

	@Override
	@Transactional
	public void delete(City city) {
		Session session = entityManager.unwrap(Session.class);
		City cityToDelete = session.get(City.class,city.getId());
		
		session.delete(cityToDelete);
		
	}

	@Override
	@Transactional
	public City getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		City city = session.get(City.class,id);
		return city;
		
	}

}
