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
public class PhoneBookTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PhoneBook cams = new PhoneBook("Cam's");
		PhoneBook amys = new PhoneBook("Amy's");
		
		PhoneBookHelper pbh = new PhoneBookHelper();
		
		pbh.insertPhoneBook(cams);
		pbh.insertPhoneBook(amys);
		
		List<PhoneBook> allBooks = pbh.showAllPhoneBooks();
		for (PhoneBook pb : allBooks) {
			System.out.println(pb.toString());
		}
		
		
		
	}

}
