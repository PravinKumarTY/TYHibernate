package com.tyss.jpatestapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpatest.dto.Movie;

public class App {

	public static void main(String[] args) {
		Movie movie = new Movie();
		movie.setId(1002);
		movie.setName("mnq");
		movie.setRating("good");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(movie);
			transaction.commit();
			System.out.println("Saved");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("hello");
			transaction.rollback();
		}finally {
			entityManager.close();
		}
	}// end of main method

}//End of class.
