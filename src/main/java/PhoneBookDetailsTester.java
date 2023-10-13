import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.PhoneBookDetailsHelper;
import model.Contact;
import model.PhoneBook;
import model.PhoneBookDetails;

/**
 * Cameron Mockobee - cmockobee1@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 13, 2023
 */
public class PhoneBookDetailsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhoneBook tom = new PhoneBook("Tom's");
		
		PhoneBookDetailsHelper pbdh = new PhoneBookDetailsHelper();
		
		Contact rick = new Contact("Rick", "1112223333", "1/1/2002");
		Contact phil = new Contact("Phil", "2223334444", "2/2/2002");
		
		List<Contact> tomsContacts = new ArrayList<Contact>();
		tomsContacts.add(rick);
		tomsContacts.add(phil);
		
		PhoneBookDetails tomsPhoneBook = new PhoneBookDetails("Tom's PhoneBook", LocalDate.now(), tom);
		tomsPhoneBook.setListOfContacts(tomsContacts);
		pbdh.insertNewPhoneBookDetails(tomsPhoneBook);
		
		List<PhoneBookDetails> allContacts = pbdh.getLists();
		for(PhoneBookDetails a: allContacts) {
			System.out.println(a.toString());
		}
	}

}
