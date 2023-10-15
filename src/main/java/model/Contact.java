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
/**
 * @author Amy Miles
 * CIS 175 - Fall 2023
 * Oct 14, 2023
 */
@Entity
@Table(name="Contact")
public class Contact {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="`PHONE NUMBER`")
	private String pNumber;
	@Column(name="`BIRTHDAY`")
	private LocalDate bDay;
	
	public Contact() {
		super();
	}

	public Contact(String name, String pNumber, LocalDate bDay) {
		super();
		this.name = name;
		this.pNumber = pNumber;
		this.bDay = bDay;
	}
	

	/**
	 * @param id
	 * @param name
	 * @param pNumber
	 * @param bDay
	 */
	public Contact(int id, String name, String pNumber, LocalDate bDay) {
		super();
		this.id = id;
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
	public LocalDate getbDay() {
		return bDay;
	}

	/**
	 * @param bDay the bDay to set
	 */
	public void setbDay(LocalDate bDay) {
		this.bDay = bDay;
	}

	@Override
	public String toString() {
		return "Contact [cName=" + name + ", pNumber=" + pNumber + ", bDay=" + bDay + "]";
	}

	
	
	
}
