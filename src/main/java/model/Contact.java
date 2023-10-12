package model;


import java.time.LocalDate;

import javax.persistence.Column;
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
@Table(name="Contacts")
public class Contact {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="PHONE NUMBER")
	private String pNumber;
	@Column(name="BIRTHDAY")
	private String bDay;
	
	public Contact() {
		super();
	}

	public Contact(String name, String pNumber, String bDay) {
		super();
		this.name = name;
		this.pNumber = pNumber;
		this.bDay = bDay;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the pNumber
	 */
	public String getpNumber() {
		return pNumber;
	}

	/**
	 * @param pNumber the pNumber to set
	 */
	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}

	/**
	 * @return the bDay
	 */
	public String getbDay() {
		return bDay;
	}

	/**
	 * @param bDay the bDay to set
	 */
	public void setbDay(String bDay) {
		this.bDay = bDay;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", pNumber=" + pNumber + ", bDay=" + bDay + "]";
	}

	
	
	
}
