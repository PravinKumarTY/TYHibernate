package com.tyss.jpatestapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpatest.dto.Movie;

public class AppGetData {

	public static void main(String[] args) {
		EntityManager entityManager=null;
		EntityManagerFactory entityManagerFactory=null;
		EntityTransaction transaction=null;
		try {
			entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
		    entityManager=entityManagerFactory.createEntityManager();
			Movie movie=entityManager.find(Movie.class, 1000);
			transaction=entityManager.getTransaction();
            transaction.begin();
			System.out.println("Movie id..:"+movie.getId());
			System.out.println("Movie Name..:"+movie.getName());
			System.out.println("Movie Rating..:"+movie.getRating());
			System.out.println(entityManager.contains(movie));
			entityManager.detach(movie);
			System.out.println(entityManager.contains(movie));
			movie.setName("xyz");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			entityManager.close();
		}
	}
}
