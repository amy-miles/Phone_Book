package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contact;
import model.PhoneBook;
import model.PhoneBookDetails;

/**
 * Servlet implementation class CreateNewPhoneBookServlet
 */
/**
 * @author Amy Miles
 * CIS 175 - Fall 2023
 * Oct 13, 2023
 */
@WebServlet("/createNewPhoneBookServlet")
public class CreateNewPhoneBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewPhoneBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pbName = request.getParameter("phonebookname");
		System.out.println("Phone Book Name: " + pbName);
		
		ContactHelper ch = new ContactHelper();
		
		String[] selectedContacts = request.getParameterValues("allContactsToAdd");
		List<Contact> selectedContactsInList = new ArrayList<Contact>();
		//make sure something was selected otherwise we get a null pointer exception
		if(selectedContacts != null && selectedContacts.length > 0) {
			for (int i = 0; i < selectedContacts.length; i++) {
				System.out.println(selectedContacts[i]);
				Contact c = ch.searchForContactById(Integer.parseInt(selectedContacts[i]));
				selectedContactsInList.add(c);				
			}
		}
		
		PhoneBook pb = new PhoneBook(pbName);
		PhoneBookDetails pbd = new PhoneBookDetails(pbName,pb);
		
		pbd.setListOfContacts(selectedContactsInList);
		PhoneBookDetailsHelper pbDetHelper = new PhoneBookDetailsHelper();
		pbDetHelper.insertNewPhoneBookDetails(pbd);
		
		System.out.println("Success!");
		System.out.println(pbd.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
