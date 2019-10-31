package com.div.testyantra.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.testyantra.dto.Student;

public class StudentUpdateApp {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=null;
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		
		try {
			entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
			entityManager=entityManagerFactory.createEntityManager();
			transaction=entityManager.getTransaction();
			transaction.begin();
			Student student=entityManager.find(Student.class,100);
			student.setName("Rohit Kumar");
			transaction.commit();
			System.out.println("Student Record updated successfully");
		} catch (Exception e) {
			transaction.commit();
			e.printStackTrace();
		}finally {
			entityManager.close();
		}


	}

}
