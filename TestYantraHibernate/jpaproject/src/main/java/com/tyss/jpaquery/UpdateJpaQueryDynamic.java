package com.tyss.jpaquery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateJpaQueryDynamic {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=null;
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
			entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
			entityManager=entityManagerFactory.createEntityManager();
			transaction=entityManager.getTransaction();
			String jpql="update Movie set name=:nm where id=:id";
			transaction.begin();
			Query query=entityManager.createQuery(jpql);
			query.setParameter("nm","Dil to pagal hai");
			query.setParameter("id",1002);
			int count=query.executeUpdate();
			System.out.println(count);
			transaction.commit();
			if(count>0) {
				System.out.println("Record updated ");
			}else {
				System.out.println("Record not updated.");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			entityManager.close();
		}
	}
}
