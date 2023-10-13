package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Amy Miles
 * CIS 175 - Fall 2023
 * Oct 13, 2023
 */

@Entity
public class PhoneBookDetails {
	@Id
	@GeneratedValue
	private int id;
	private String phoneBookName;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private PhoneBook phoneBook;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<Contact> listOfContacts;
	
	/**
	 * Default no-arg constructor for JPA
	 */
	public PhoneBookDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param listName
	 * @param phoneBook
	 * @param listOfContacts
	 */
	public PhoneBookDetails(int id, String phoneBookName, PhoneBook phoneBook, List<Contact> listOfContacts) {
		super();
		this.id = id;
		this.phoneBookName = phoneBookName;
		this.phoneBook = phoneBook;
		this.listOfContacts = listOfContacts;
	}

	/**
	 * @param listName
	 * @param phoneBook
	 * @param listOfContacts
	 */
	public PhoneBookDetails(String phoneBookName, PhoneBook phoneBook, List<Contact> listOfContacts) {
		super();
		this.phoneBookName = phoneBookName;
		this.phoneBook = phoneBook;
		this.listOfContacts = listOfContacts;
	}

	/**
	 * @param listName
	 * @param phoneBook
	 */
	public PhoneBookDetails(String phoneBookName, PhoneBook phoneBook) {
		super();
		this.phoneBookName = phoneBookName;
		this.phoneBook = phoneBook;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the listName
	 */
	public String getPhoneBookName() {
		return phoneBookName;
	}

	/**
	 * @param listName the listName to set
	 */
	public void setListName(String phoneBookName) {
		this.phoneBookName = phoneBookName;
	}

	/**
	 * @return the phoneBook
	 */
	public PhoneBook getPhoneBook() {
		return phoneBook;
	}

	/**
	 * @param phoneBook the phoneBook to set
	 */
	public void setPhoneBook(PhoneBook phoneBook) {
		this.phoneBook = phoneBook;
	}

	/**
	 * @return the listOfContacts
	 */
	public List<Contact> getListOfContacts() {
		return listOfContacts;
	}

	/**
	 * @param listOfContacts the listOfContacts to set
	 */
	public void setListOfContacts(List<Contact> listOfContacts) {
		this.listOfContacts = listOfContacts;
	}

	@Override
	public String toString() {
		return "PhoneBookDetails [id=" + id + ", phoneBookName=" + phoneBookName + ", phoneBook=" + phoneBook
				+ ", listOfContacts=" + listOfContacts + "]";
	}

	
	
	
	
	
	
}
