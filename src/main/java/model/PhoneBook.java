package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Cameron Mockobee - cmockobee1@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 10, 2023
 */
@Entity
@Table(name="PhoneBook")
public class PhoneBook {
	@Id
	@GeneratedValue
	private int id;
	private String phoneBookName;
	
	public PhoneBook() {
		super();
	}

	public PhoneBook(int id, String phoneBookName) {
		super();
		this.id = id;
		this.phoneBookName = phoneBookName;
	}

	public PhoneBook(String phoneBookName) {
		super();
		this.phoneBookName = phoneBookName;
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
	 * @return the phoneBookName
	 */
	public String getPhoneBookName() {
		return phoneBookName;
	}

	/**
	 * @param phoneBookName the phoneBookName to set
	 */
	public void setPhoneBookName(String phoneBookName) {
		this.phoneBookName = phoneBookName;
	}

	@Override
	public String toString() {
		return "PhoneBook [id=" + id + ", phoneBookName=" + phoneBookName + "]";
	}
	
	
}
