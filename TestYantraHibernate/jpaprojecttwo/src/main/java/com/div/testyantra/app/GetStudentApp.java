package com.div.testyantra.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.testyantra.dto.Student;

public class GetStudentApp {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=null;
		EntityManager entityManager=null;
		
		try {
			entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
			entityManager=entityManagerFactory.createEntityManager();
			Student student=entityManager.find(Student.class, 100);
			System.out.println("Student Id."+student.getId());
			System.out.println("Student Name..:"+student.getName());
			System.out.println("Student Addresss..:"+student.getAddress());
			System.out.println("Student Phno..:"+student.getPhno());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			entityManager.close();
		}


	}

}
