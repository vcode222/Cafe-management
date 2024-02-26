import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

/**
* Servlet implementation class UpdateCustomer
*/ @WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet { private static final long serialVersionUID = 1L; Connection conn = null;
PreparedStatement ps = null;
/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
PrintWriter out = response.getWriter(); 
out.println("<html>");
out.println("<head><title>UPDATE CHANGES</title></head>");
out.println("<style> body{background-color:#EADDCA;background-repeat: no-repeat;background-size: cover;background-attachment: fixed;</style>");
out.println("<body>");
out.println("<h1 align='center'>CHANGE YOUR ORDER</h1>"); 
out.println("<hr />");
try {
Class.forName("com.mysql.cj.jdbc.Driver");
String URL = "jdbc:mysql://localhost:3306/cafe";
conn = DriverManager.getConnection(URL, "root", "venkatesh"); 
ps = conn.prepareStatement("update coffee set name = ?,cost = ?,qty= ? where id = ?");
ps.setInt(4, Integer.parseInt(request.getParameter("id")));
ps.setString(1, request.getParameter("name"));
ps.setInt(2, Integer.parseInt(request.getParameter("cost")));
ps.setInt(3, Integer.parseInt(request.getParameter("qty")));
int res = ps.executeUpdate();
if (res != 0)
out.println("<h1>YOUR ORDER  HAS BEEN CHANGED SUCCESSFULLY.</h1>");
else
out.println("<h1>FAILED!! CAN'T CHANGE YOUR ORDER</h1>");
ps.close();
conn.close();
} catch (Exception e) { out.println(e);
}
 
out.println("<br />");
out.println("<a href='ViewProduct'><h2>BACK</h2></a>"); 
out.println("</body></html>");
}

}

