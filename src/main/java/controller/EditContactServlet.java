package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contact;

/**
 * Servlet implementation class EditContactServlet
 */
@WebServlet("/editContactServlet")
public class EditContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditContactServlet() {
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
		ContactHelper ch = new ContactHelper();
		
		
		String name = request.getParameter("name");
		String pnum = request.getParameter("pNumber");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Contact toUpdate = ch.searchForContactById(tempId);
		
		toUpdate.setName(name);
		toUpdate.setpNumber(pnum);
		toUpdate.setbDay(ld);
		
		ch.updateContact(toUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllContactsServlet").forward(request, response);
	}

}
