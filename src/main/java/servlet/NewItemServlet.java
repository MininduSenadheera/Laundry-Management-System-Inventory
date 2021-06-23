package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ItemDao;
import model.Item;

/**
 * Servlet implementation class NewItemServlet
 */
@WebServlet("/NewItemServlet")
public class NewItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ItemDao itemDao;

	public void init(){
		itemDao = new ItemDao();
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Item item = new Item();
		item.setItemName(request.getParameter("name"));
		item.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		item.setPrice(Double.parseDouble(request.getParameter("price")));
		item.setSupplier(request.getParameter("supplier"));

		boolean trueorfalse;
		try {
			trueorfalse = itemDao.AddItem(item);
			//checking whether the registration has updated in the database
			if(trueorfalse == true){
				PrintWriter printWriter = response.getWriter();  
				response.setContentType("text/html");  
				printWriter.println("<script type=\"text/javascript\">"); 
				printWriter.println("alert('Added Successful');");  
				printWriter.println("window.location.replace('inventory.jsp');");
				printWriter.println("</script>");
			}
			else{
				//if updating is unsuccessful display an alert an redirect to sign up page again
				PrintWriter printWriter = response.getWriter();  
				response.setContentType("text/html");  
				printWriter.println("<script type=\"text/javascript\">"); 
				printWriter.println("alert('Unsuccessful');");  
				printWriter.println("window.location.replace('additem.jsp');");
				printWriter.println("</script>");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
