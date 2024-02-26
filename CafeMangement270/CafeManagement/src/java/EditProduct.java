
import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

/**
* Servlet implementation class EditCustomer
*/ @WebServlet("/EditProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L; Connection conn = null;
PreparedStatement ps = null; ResultSet rs = null;

/**
*	@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
*	response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
PrintWriter out = response.getWriter(); 
out.println("<html>");
out.println("<head><title>CHANGE ORDER</title></head>");
out.println("<style> body{background-color:#EADDCA;background-repeat: no-repeat;background-size: cover;background-attachment: fixed;</style>");
out.println("<body>");
out.println("<h1 align='center'>CHANGE ORDER</h1>"); 
out.println("<hr />");
try {
Class.forName("com.mysql.cj.jdbc.Driver");
String URL = "jdbc:mysql://localhost:3306/cafe";
conn = DriverManager.getConnection(URL, "root", "venkatesh");
ps = conn.prepareStatement("select * from coffee where id = ?");
ps.setInt(1,Integer.parseInt(request.getParameter(("id")))); 
rs = ps.executeQuery();
rs.next();
out.println("<form action='UpdateProduct' method='post'>"); 
out.println("<table>");
out.println("<tr>"); 
out.println("<td>ORDER NO:</td>");
out.println("<td><input type='text' name='id' value='" + rs.getInt("id") + "' readonly></td>"); 
out.println("</tr>");

out.println("<tr>");
out.println("<td>COFFEE NAME:</td>"); 
out.println("<td><input type='text' name='name' value='" + rs.getString("name") + "'></td>");
out.println("</tr>");

out.println("<tr>"); 
out.println("<td>PRICE:</td>");
out.println("<td><input type='text' name='cost' value='" + rs.getString("cost") + "'></td>"); 
out.println("</tr>");

out.println("<tr>"); 
out.println("<td>QUANTITY:</td>");
out.println("<td><input type='text' name='qty' value='" + rs.getInt("qty") + "'></td>"); 
out.println("</tr>");


out.println("<tr>");
out.println("<td colspan='5' align='center'><input type='submit' value='Update Product'></td>"); out.println("</tr>");
out.println("</table>"); out.println("</form>"); ps.close();
conn.close();
} catch (Exception e) 
{ 
	out.println(e);
}
out.println("<br />");
out.println("<a href='ViewProduct'><h2>BACK</h2></a>"); out.println("</body></html>");
}
}
