package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.PhoneBook;

/**
 * @author Amy Miles
 * CIS 175 - Fall 2023
 * Oct 13, 2023
 */
public class PhoneBookHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PhoneBook");
	
	public void insertPhoneBook(PhoneBook pb) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(pb);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<PhoneBook> showAllPhoneBooks(){
		EntityManager em = emfactory.createEntityManager();
		List<PhoneBook> allPhoneBooks = em.createQuery("SELECT p FROM PhoneBook p").getResultList();
		return allPhoneBooks;
	}
	/*
	 * (Cam Mockobee)
	 * method for finding phonebook
	 */
	public PhoneBook findPhoneBook(String phoneBookToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<PhoneBook> typedQuery = em.createQuery("select pb from PhoneBook pb where pb.phoneBookName = :selectedName", PhoneBook.class);
		typedQuery.setParameter("selectedName", phoneBookToLookUp);
		typedQuery.setMaxResults(1);
		
		PhoneBook foundPhoneBook;
		try {
			foundPhoneBook = typedQuery.getSingleResult();
		}catch(NoResultException ex) {
			foundPhoneBook = new PhoneBook(phoneBookToLookUp);
		}
		em.close();
		
		return foundPhoneBook;
	}
}
