package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contact;

/**
 * Servlet implementation class NavServlet
 */
@WebServlet("/navServlet")
public class NavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavServlet() {
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
		String act= request.getParameter("doThisToContact");
		
		String path= "/viewAllContactsServlet";
		
		if(act.equals("delete")){
		 try {
			Integer tempId=Integer.parseInt(request.getParameter("id"));
			Contact contactToDelete = ch.searchForContactById(tempId);
			ch.deleteContact(contactToDelete);
		 }catch (NumberFormatException e) {
			 System.out.println("Select a contact!");
		 }
		}else if(act.equals("edit")) {
		 try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Contact contactToEdit = ch.searchForContactById(tempId);
			request.setAttribute("contactToEdit", contactToEdit);
			path = "/edit-contact.jsp";
		 }catch (NumberFormatException e) {
			 System.out.println("Select a contact!!");
		 }
		}else if(act.equals("add")) {
			path="/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
