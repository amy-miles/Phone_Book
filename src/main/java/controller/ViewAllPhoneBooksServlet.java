package controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PhoneBookDetails;
/**
 * Servlet implementation class ViewAllPhoneBooksServlet
 */
@WebServlet("/viewAllPhoneBooksServlet")
public class ViewAllPhoneBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllPhoneBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PhoneBookDetailsHelper pbdh = new PhoneBookDetailsHelper();
		List<PhoneBookDetails> abc = pbdh.getLists();
		
		request.setAttribute("allPhoneBooks", abc);//like view allLists
		
		if(abc.isEmpty()) {
			request.setAttribute("allPhoneBooks", " ");
		}
		getServletContext().getRequestDispatcher("/contacts-list-by-phonebook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
