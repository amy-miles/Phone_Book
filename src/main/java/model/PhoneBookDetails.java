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
	private String bookDetailsName;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private PhoneBook phoneBook;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
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
	 * @param bookDetailsName
	 * @param phoneBook
	 * @param listOfContacts
	 */
	public PhoneBookDetails(int id, String bookDetailsName, PhoneBook phoneBook, List<Contact> listOfContacts) {
		super();
		this.id = id;
		this.bookDetailsName = bookDetailsName;
		this.phoneBook = phoneBook;
		this.listOfContacts = listOfContacts;
	}

	/**
	 * @param bookDetailsName
	 * @param phoneBook
	 * @param listOfContacts
	 */
	public PhoneBookDetails(String bookDetailsName, PhoneBook phoneBook, List<Contact> listOfContacts) {
		super();
		this.bookDetailsName = bookDetailsName;
		this.phoneBook = phoneBook;
		this.listOfContacts = listOfContacts;
	}

	/**
	 * @param listName
	 * @param phoneBook
	 */
	public PhoneBookDetails(String bookDetailsName, PhoneBook phoneBook) {
		super();
		this.bookDetailsName = bookDetailsName;
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
	public String getBookDetailsName() {
		return bookDetailsName;
	}

	/**
	 * @param listName the listName to set
	 */
	public void setBookDetailsName(String bookDetailsName) {
		this.bookDetailsName = bookDetailsName;
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
		return "PhoneBookDetails [id=" + id + ", bookDetailsName=" + bookDetailsName + ", phoneBook=" + phoneBook
				+ ", listOfContacts=" + listOfContacts + "]";
	}

	
	
	
	
	
	
}
