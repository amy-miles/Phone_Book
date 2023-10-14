package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PhoneBook;
import model.PhoneBookDetails;
import model.Contact;

/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PhoneBookDetailsHelper pbdh = new PhoneBookDetailsHelper();
		
		ContactHelper ch = new ContactHelper();
		PhoneBookHelper pbh = new PhoneBookHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		PhoneBookDetails phoneBookDetailsToUpdate = pbdh.searchForDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String phoneBookName = request.getParameter("PhoneBookName");
		
		PhoneBook newPhoneBook = pbh.findPhoneBook(phoneBookName);
		
		LocalDate ld;
		
		/*
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		*/
		try {
			String[] selectedContacts = request.getParameterValues("allContactsToAdd");
			List<Contact> selectedContactsInList = new ArrayList<Contact>();
			
			for(int i=0; i<selectedContacts.length; i++) {
				System.out.println(selectedContacts[i]);
			Contact c = ch.searchForContactById(Integer.parseInt(selectedContacts[i]));	
				selectedContactsInList.add(c);
			}
			phoneBookDetailsToUpdate.setListOfContacts(selectedContactsInList);
 		}catch (NullPointerException ex) {
 			List<Contact> selectedContactsInList = new ArrayList<Contact>();
 			phoneBookDetailsToUpdate.setListOfContacts(selectedContactsInList);
 		}
		phoneBookDetailsToUpdate.setListName(newListName);
		//phoneBookDetailsToUpdate.setTripDate(ld);
		phoneBookDetailsToUpdate.setPhoneBook(newPhoneBook);
		
		pbdh.updatePhoneBook(phoneBookDetailsToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		
	}
}
