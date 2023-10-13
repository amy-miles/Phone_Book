import java.util.ArrayList;
import java.util.List;

import controller.PhoneBookDetailsHelper;
import controller.PhoneBookHelper;
import model.Contact;
import model.PhoneBook;
import model.PhoneBookDetails;

/**
 * @author Amy Miles
 * CIS 175 - Fall 2023
 * Oct 13, 2023
 */
public class PhoneBookDetailsTester {

	public static void main(String[] args) {
		PhoneBook amys = new PhoneBook("Amy's");

		PhoneBookDetailsHelper pbdh = new PhoneBookDetailsHelper();

		// create a couple of contacts
		Contact john = new Contact("John", "515-512-0004", "May 27");
		Contact parker = new Contact("Parker", "515-512-0004", "May 27");
		
		// add contacts to a phone list
		List<Contact> phoneList = new ArrayList<Contact>();
		phoneList.add(john);
		phoneList.add(parker);

		PhoneBookDetails amysList = new PhoneBookDetails("Amy's Phone List", amys);
		amysList.setListOfContacts(phoneList);

		pbdh.insertNewPhoneBookDetails(amysList);

		List<PhoneBookDetails> allLists = pbdh.getLists();
		for (PhoneBookDetails pbd : allLists) {
			System.out.println(pbd.toString());
		}

	}

}
