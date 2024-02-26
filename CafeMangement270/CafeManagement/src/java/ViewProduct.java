import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
* Servlet implementation class ViewEmployee
*/ @WebServlet("/ViewProduct")
public class ViewProduct extends HttpServlet { private static final long serialVersionUID = 1L; Connection conn = null;
PreparedStatement ps = null; ResultSet rs = null;
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{ 
PrintWriter out = response.getWriter(); 
out.println("<html>"); 
out.println("<head><title>VIEW ORDER</title></head>");
out.println("<style> body{background-color:#EADDCA;background-repeat: no-repeat;background-size: cover;background-attachment: fixed;</style>");
out.println("<body>");
out.println("<h1 align='center'>VIEW ALL ORDERS</h1>"); 
out.println("<hr />");
try {
Class.forName("com.mysql.cj.jdbc.Driver");
String URL = "jdbc:mysql://localhost:3306/cafe";
conn = DriverManager.getConnection(URL, "root", "venkatesh");
ps = conn.prepareStatement("select * from coffee order by id");
rs = ps.executeQuery();
out.println("<table border='1'>");
out.println("<tr>");
out.println(" <td><h2> OREDER NO: </h2></td> "); 
out.println(" <td><h2> COFFEE NAME :</h2></td> "); 
out.println(" <td><h2> PRICE:</h2></td> ");
out.println(" <td><h2> QUANTITY:</h2></td>");
out.println(" <td><h2> CHANGE </h2></td> "); 
out.println(" <td><h2> REMOVE</h2></td> "); 
out.println("</tr>");
 
while (rs.next())
{
out.println("<tr>");
out.println("<td>" + rs.getInt("id") + "</td>"); 
out.println("<td>" + rs.getString("name") + "</td>");
out.println("<td>" + rs.getInt("cost") + "</td>");
out.println("<td>" + rs.getInt("qty") + "</td>");
out.println("<td><a href='EditProduct?id=" + rs.getInt("id") + "'>CHANGE</a></td>"); 
out.println("<td><a href='DeleteProduct?id=" + rs.getInt("id") + "'>REMOVE</a></td>");
out.println("</tr>");
}
out.println("</table>");
ps.close();
conn.close();
} catch (Exception e)
{ 
	out.println(e);
}
out.println("<br />");
out.println("<a href='Product.html'><h2>BACK</h2></a>");
out.println("</body></html>");
}

}
