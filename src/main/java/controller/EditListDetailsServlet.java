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
		PhoneBookDetailsHelper pbdh = new PhoneBookDetailsHelper();
		ContactHelper ch = new ContactHelper();
		PhoneBookHelper pbh = new PhoneBookHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		PhoneBookDetails detailsToUpdate = pbdh.searchForDetailsById(tempId);//get the PhoneBookDetailsObject to edit
		
		String newBookDetailsName = request.getParameter("bookDetailsName");//info from edit-list get a new details name?
		
		String phoneBookName = request.getParameter("phoneBookName");//
		
		//find the phone book
		PhoneBook newPhoneBook = pbh.findPhoneBook(phoneBookName);
		
		try {
			String[] selectedContacts = request.getParameterValues("allContactsToAdd");
			List<Contact> selectedContactsInList = new ArrayList<Contact>();
		
			for (int i = 0; i < selectedContacts.length; i++) {
				System.out.println(selectedContacts[i]);
				Contact c = ch.searchForContactById(Integer.parseInt(selectedContacts[i]));
				selectedContactsInList.add(c);
		
			}
			detailsToUpdate.setListOfContacts(selectedContactsInList);
		}catch(NullPointerException ex) {
			//no contacts selected in list set to an empty list
			List<Contact> selectedContactsInList = new ArrayList<Contact>();
			detailsToUpdate.setListOfContacts(selectedContactsInList);
		}
		
		detailsToUpdate.setBookDetailsName(newBookDetailsName);
		detailsToUpdate.setPhoneBook(newPhoneBook);
		
		pbdh.updateList(detailsToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllPhoneBooksServlet").forward(request, response);
	}

}
