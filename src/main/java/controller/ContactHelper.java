package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ContactModel;


/**
 * Cameron Mockobee - cmockobee1@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 10, 2023
 */
public class ContactHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PhoneBook");
	
	public void insertContact(ContactModel c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ContactModel> showAllContacts(){
		EntityManager em = emfactory.createEntityManager();
		List<ContactModel> allContacts = em.createQuery("SELECT C FROM Contact c").getResultList();
		return allContacts;
	}
	
	public void deleteContact(ContactModel toBeDeleted) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ContactModel> tq = em.createQuery("SELECT c FROM ContactModel c WHERE c.Name = :selectedName", ContactModel.class);
	
		tq.setParameter("selectedFirstName", toBeDeleted.getName());
		tq.setMaxResults(1);
		
		ContactModel outcome = tq.getSingleResult();
		
		em.remove(outcome);
		em.getTransaction().commit();
		em.close();
	}
	
	public void formatName() {
		
	}
	
	public void formatNumber() {
		
	}
}
