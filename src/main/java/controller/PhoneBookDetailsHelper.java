package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
	
	public void deleteList(PhoneBookDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PhoneBookDetails> typedQuery = em.createQuery("select detail from PhoneBookDetails where detail.id = :selectedId", PhoneBookDetails.class);
		//substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		//get one result
		typedQuery.setMaxResults(1);
		//get result and save it into a new list entry
		PhoneBookDetails result = typedQuery.getSingleResult();
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();		
	}
	
	public PhoneBookDetails searchForDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		PhoneBookDetails found = em.find(PhoneBookDetails.class, tempId);
		em.close();
		return found;
	}
	/*
	 * (Cam Mockobee)
	 * method for updating phonebook details
	 */
	public void updatePhoneBook(PhoneBookDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction();
		em.close();
	}
}
