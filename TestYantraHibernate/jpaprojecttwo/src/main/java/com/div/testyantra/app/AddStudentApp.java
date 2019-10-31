package com.div.testyantra.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.testyantra.dto.Student;

public class AddStudentApp {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=null;
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		
		try {
			Student student=new Student();
			student.setId(101);
			student.setName("Rahul Kumar");
			student.setAddress("Jp nagar");
			student.setPhno(8095757848l);
			entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
			entityManager=entityManagerFactory.createEntityManager();
			transaction=entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(student);
			transaction.commit();
			System.out.println("Student Record added successfully");
		} catch (Exception e) {
			transaction.commit();
			e.printStackTrace();
		}finally {
			entityManager.close();
		}

	}
}
