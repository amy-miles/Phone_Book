package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
	
	
}
