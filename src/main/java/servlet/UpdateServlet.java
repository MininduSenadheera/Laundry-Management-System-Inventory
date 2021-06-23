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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ItemDao itemDao;

	public void init(){
		itemDao = new ItemDao();
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Item item = new Item();
		item.setItemCode(request.getParameter("code"));
		item.setItemName(request.getParameter("name"));
		item.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		item.setPrice(Double.parseDouble(request.getParameter("price")));
		item.setSupplier(request.getParameter("supplier"));

		boolean trueorfalse;
		
		try {
			trueorfalse = itemDao.UpdateItem(item.getItemCode(), item);
			//checking whether the changes has updated in the database
			if(trueorfalse == true){
				PrintWriter printWriter = response.getWriter();  
				response.setContentType("text/html");  
				printWriter.println("<script type=\"text/javascript\">"); 
				printWriter.println("alert('Updated Successfully');");  
				printWriter.println("window.location.replace('inventory.jsp');");
				printWriter.println("</script>");
			}
			else{
				PrintWriter printWriter = response.getWriter();  
				response.setContentType("text/html");  
				printWriter.println("<script type=\"text/javascript\">"); 
				printWriter.println("alert('Unsuccessful');");  
				printWriter.println("window.location.replace('updateitem.jsp');");
				printWriter.println("</script>");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
