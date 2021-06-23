package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ItemDao;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ItemDao itemDao;

	public void init(){
		itemDao = new ItemDao();
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String code = request.getParameter("code");

		boolean trueorfalse;
		try {
			trueorfalse = itemDao.deleteItem(code);
			//checking whether the item has deleted
			if(trueorfalse == true){
				PrintWriter printWriter = response.getWriter();  
				response.setContentType("text/html");  
				printWriter.println("<script type=\"text/javascript\">"); 
				printWriter.println("alert('Deleted Successfully');");  
				printWriter.println("window.location.replace('inventory.jsp');");
				printWriter.println("</script>");
			}
			else{
				PrintWriter printWriter = response.getWriter();  
				response.setContentType("text/html");  
				printWriter.println("<script type=\"text/javascript\">"); 
				printWriter.println("alert('Unsuccessful');");  
				printWriter.println("window.location.replace('inventory.jsp');");
				printWriter.println("</script>");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
