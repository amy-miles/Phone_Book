package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddContactsForPhoneBookServlet
 * gathers all of the contacts in the db to put on the list 
 */
@WebServlet("/addContactsForPhoneBookServlet")
public class AddContactsForPhoneBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContactsForPhoneBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactHelper ch = new ContactHelper();
				
		request.setAttribute("allContacts", ch.showAllContacts());
		
		if (ch.showAllContacts().isEmpty()) {
			request.setAttribute("allContacts", " ");
		}
		
		getServletContext().getRequestDispatcher("/new-phone-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
