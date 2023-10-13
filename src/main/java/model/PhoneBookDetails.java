package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Cameron Mockobee - cmockobee1@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 13, 2023
 */

@Entity
public class PhoneBookDetails {
	@Id
	@GeneratedValue
	private int id;
	private String pBListName;
	private LocalDate dateCreated;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private PhoneBook phoneBook;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<Contact> listOfContacts;
	
	public PhoneBookDetails() {
		super();
	}

	public PhoneBookDetails(String pBListName, PhoneBook phoneBook, List<Contact> listOfContacts) {
		super();
		this.pBListName = pBListName;
		this.phoneBook = phoneBook;
		this.listOfContacts = listOfContacts;
	}
	
	public PhoneBookDetails(String pBListName, LocalDate dateCreated, PhoneBook phoneBook) {
		super();
		this.pBListName = pBListName;
		this.dateCreated = dateCreated;
		this.phoneBook = phoneBook;
	}

	public PhoneBookDetails(String pBListName, LocalDate dateCreated) {
		super();
		this.pBListName = pBListName;
		this.dateCreated = dateCreated;
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
	 * @return the pBListName
	 */
	public String getpBListName() {
		return pBListName;
	}

	/**
	 * @param pBListName the pBListName to set
	 */
	public void setpBListName(String pBListName) {
		this.pBListName = pBListName;
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
		return "PhoneBookDetails [id=" + id + ", pBListName=" + pBListName + ", phoneBook=" + phoneBook
				+ ", listOfContacts=" + listOfContacts + "]";
	}
	
	
}
