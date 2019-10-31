package com.tyss.jpatestapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tyss.jpatest.dto.Movie;

public class GetAppDataByGetReference {

	
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		//Movie movie=entityManager.find(Movie.class, 1004);
		
		Movie movie=entityManager.getReference(Movie.class,1006);
		System.out.println(movie.getRating());
		/*System.out.println("Movie id..:"+movie.getId());
		System.out.println("Movie Name..:"+movie.getName());
		System.out.println("Movie Rating..:"+movie.getRating());*/
	}
}
