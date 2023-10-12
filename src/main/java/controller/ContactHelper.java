package controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Contact;


/**
 * Cameron Mockobee - cmockobee1@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 10, 2023
 */
public class ContactHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ContactsList");
	
	public void insertContact(Contact c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Contact> showAllContacts(){
		EntityManager em = emfactory.createEntityManager();
		List<Contact> allContacts = em.createQuery("SELECT c FROM Contact c", Contact.class).getResultList();
		return allContacts;
	}
	
	public void deleteContact(Contact toBeDeleted) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Contact> tq = em.createQuery("SELECT c FROM Contact c WHERE c.cname = :selectedCName", Contact.class);
	
		tq.setParameter("selectedCName", toBeDeleted.getCName());
		tq.setMaxResults(1);
		
		Contact outcome = tq.getSingleResult();
		
		em.remove(outcome);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Method to update the contact
	 * updates the database with the contact info that was edited by user
	 * (Amy Miles)
	 * @param toBeUpdated
	 */
	public void updateContact(Contact toBeUpdated) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toBeUpdated);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Method to search db by contact id
	 * (Amy Miles)
	 * @param idToEdit
	 * @return found the contact with the matching id
	 */
	public Contact searchForContactById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Contact found = em.find(Contact.class, idToEdit);
		return found;
	}
	
	public Contact searchForContactByName(String name) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Contact found = em.find(Contact.class, name);
		return found;
	}

	public List<Contact> getListOfMatchingContacts(String name){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Contact> typedQuery = em.createQuery("select c from Contact c where c.cname = :selectedContact", Contact.class );
		typedQuery.setParameter("selectedContact", name);
		
		List<Contact> foundContacts = typedQuery.getResultList();
		em.close();
		
		return foundContacts;
		
	}
	
	/**
	 * Removes special characters then 
	 * Formats a phone number to (###) ###-####
	 * (Amy Miles)
	 * @param num input by user
	 * @return number formatted number
	 */
	public String formatNumber(String num) {
		//removes all non digits
		String temp = num.replaceAll("[\\D]", "");
		//formats
		String number = temp.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");
		return number;
	}
	
	/**
	 * Method to validate that user input phone number contains 10 digits
	 * removes all special characters then evaluates
	 * (Amy Miles)
	 * @param num string to be evaluated
	 * @return boolean true if contains 10 digits
	 */
	public boolean validatePhoneNumber(String num) {
		//removes all non digits
		String temp = num.replaceAll("[\\D]", "");
		//checks for ten digits
		String regex = "^\\d{10}$";//regex pattern to check for ten digits
		Pattern pattern = Pattern.compile(regex);//create pattern
		Matcher matcher = pattern.matcher(temp);//create matcher
		return matcher.matches(); //evaluate: returns true if 10 digits
	}
	
	/**
	 * 
	 */
	public void cleanUp() {
		emfactory.close();
	}
}
