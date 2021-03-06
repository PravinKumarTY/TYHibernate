package com.tyss.mapping.app;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.manytomany.Cources;
import com.tyss.manytomany.Student;

public class ManyToManyApp {

	public static void main(String[] args) {
		List<Student> listOfStudent=new ArrayList<Student>();
		List<Cources> listOfCources=new ArrayList<Cources>();
		
		EntityManagerFactory emf=null;
		EntityManager em=null;
		EntityTransaction transaction=null;
		
		Cources cource1=new Cources();
		cource1.setCid(1000);
		cource1.setcName("Java");
		cource1.setStudentList(listOfStudent);
		
		Cources cource2=new Cources();
		cource2.setCid(10001);
		cource2.setcName("PHP");
		cource2.setStudentList(listOfStudent);
		
		Student student1=new Student();
		student1.setSid(100);
		student1.setSname("Pravin Kumar");
		student1.setsAddress("Btm");
		
		
		Student student2=new Student();
		student2.setSid(101);
		student2.setSname("Rahul Kumar");
		student2.setsAddress("JP Nagar");
		listOfStudent.add(student1);
		listOfStudent.add(student2);
		
	    student1.setCourcesList(listOfCources);
		student2.setCourcesList(listOfCources);
			emf=Persistence.createEntityManagerFactory("TestPersistence");
			em=emf.createEntityManager();
			transaction=em.getTransaction();
			transaction.begin();
			em.persist(student1);
			em.persist(student2);
//			em.persist(cource1);
//			em.persist(cource2);
			transaction.commit();
			System.out.println("Record Inserted..");
		
	}
}
