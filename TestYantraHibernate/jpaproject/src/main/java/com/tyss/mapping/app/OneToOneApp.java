package com.tyss.mapping.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.onetoone.Person;
import com.tyss.onetoone.VoterIdCard;

public class OneToOneApp {

	public static void main(String[] args) {
		Person person=new Person();
		person.setId(1002);
		person.setName("Raman Kumar");
		person.setAddress("Hsr");

		VoterIdCard voterId=new VoterIdCard();
		voterId.setVid(100002);
		voterId.setIdName("VoterId");
		person.setVoterId(voterId);

		EntityManagerFactory emf=null;
		EntityManager em=null;
		EntityTransaction transaction=null;
		try {
			emf=Persistence.createEntityManagerFactory("TestPersistence");
			em=emf.createEntityManager();
			transaction=em.getTransaction();
			transaction.begin();
			em.persist(person);
			transaction.commit();
			Person p=em.find(VoterIdCard.class,100000).getPerson();
			System.out.println("Person id"+p.getId());
			System.out.println("Person Name"+p.getName());
			
			System.out.println("Person and Voter_Id  Created..");
		} catch (Exception e) {
			transaction.rollback();
		}finally {
			em.close();
		}
	}//End of Main.
}//End of Class.
