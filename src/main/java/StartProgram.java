import controller.ContactHelper;
import model.Contact;

import java.util.List;
import java.util.Scanner;


public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ContactHelper ch = new ContactHelper();

		private static void addContact() {
			// TODO Auto-generated method stub
			System.out.print("Enter a name: ");
			String name = in.nextLine();
			System.out.print("Enter the phone number: ");
			String pNumber = in.nextLine();
			System.out.print("Enter the birthday: ");
			String bDay = in.nextLine();			
			Contact toAdd = new Contact(name, pNumber, bDay);
			ch.insertContact(toAdd);
		}		

		private static void deleteContact() {
			// TODO Auto-generated method stub
			System.out.print("Enter the name to delete: ");
			String name = in.nextLine();
			Contact contactToDelete = ch.searchForContactByName(name);
			ch.deleteContact(contactToDelete);
		}

		private static void editContact() {
			// TODO Auto-generated method stub
			System.out.print("Enter the contact name: ");
			String contactToEdit = in.nextLine();
			List<Contact> foundContacts;
			foundContacts = ch.getListOfMatchingContacts(contactToEdit);
			if (!foundContacts.isEmpty()) {
				System.out.println("Found Results.");
				for (Contact c : foundContacts) {
					System.out.println(c.getId() + " : " + c.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				Contact toEdit = ch.searchForContactById(idToEdit);

				System.out.println("Retrieved: Name " + toEdit.getName() + " Birthday:  " + toEdit.getbDay() + " Number: " + toEdit.getpNumber());
				
				System.out.println("1 : Update Name");
				System.out.println("2 : Update Number");
				System.out.println("3 : Update Birthday");
				
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("Updated Name: ");
					String newName = in.nextLine();
					toEdit.setName(newName);
				}if (update == 2) {
					System.out.print("Updated number: ");
					String newNumber = in.nextLine();
					toEdit.setpNumber(newNumber);
				}else if (update == 3) {
					System.out.print("Updated birthday: ");
					String newbDay = in.nextLine();					
					toEdit.setbDay(newbDay);
				}

				ch.updateContact(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}
		
	

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to the phone book app! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add a contact");
				System.out.println("*  2 -- Edit a contact");
				System.out.println("*  3 -- Delete a contact");
				System.out.println("*  4 -- View contact list");
				System.out.println("*  5 -- Exit program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addContact();
				} else if (selection == 2) {
					editContact();
				} else if (selection == 3) {
					deleteContact();
				} else if (selection == 4) {
					viewTheList();
				} else {
					ch.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<Contact> allContacts = ch.showAllContacts();
			for (Contact singleContact : allContacts) {
				System.out.println(singleContact.toString());
			}

		}

	}