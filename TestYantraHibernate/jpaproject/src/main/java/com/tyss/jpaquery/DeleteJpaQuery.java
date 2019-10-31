package com.tyss.jpaquery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteJpaQuery {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=null;
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
			entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
			entityManager=entityManagerFactory.createEntityManager();
			transaction=entityManager.getTransaction();
			//String jpql="delete from Movie where id=1000";
			String jpql="delete from Movie where id=:id";
			transaction.begin();
			Query query=entityManager.createQuery(jpql);
			query.setParameter("id",1003);
			int count=query.executeUpdate();
			transaction.commit();
			if(count>0) {
				System.out.println("Record Deleted ");
			}else {
				System.out.println("Record not Deleted.");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			entityManager.close();
		}
	}
}
