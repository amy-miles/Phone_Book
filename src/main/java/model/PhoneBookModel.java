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
@Table(name="Phone Book")
public class PhoneBookModel {
	@Id
	@GeneratedValue
	private int id;
	private String phoneBookName;
	
	
}
