package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.PhoneBookDetails;

/**
 * @author Amy Miles
 * CIS 175 - Fall 2023
 * Oct 13, 2023
 */
public class PhoneBookDetailsHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PhoneBook");
	
	public void insertNewPhoneBookDetails(PhoneBookDetails pbd) {		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(pbd);
		em.getTransaction().commit();
		em.close();		
	}
	
	public List<PhoneBookDetails> getLists(){
		EntityManager em = emfactory.createEntityManager();
		List<PhoneBookDetails> allDetails = em.createQuery("SELECT d FROM PhoneBookDetails d").getResultList();
		return allDetails;
	}
	
}
