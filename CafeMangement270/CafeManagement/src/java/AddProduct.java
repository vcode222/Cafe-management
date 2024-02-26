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
* Servlet implementation class AddEmployee
*/ @WebServlet("/AddProduct")
public class AddProduct extends HttpServlet
{ 
private static final long serialVersionUID = 1L; 
Connection conn = null;
PreparedStatement ps = null;
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
PrintWriter out = response.getWriter(); out.println("<html>");
out.println("<head><title>PLACE  ORDER</title></head>");
out.println("<style> body{background-color:#EADDCA;background-repeat: no-repeat;background-size: cover;background-attachment: fixed;}</style>");
out.println("<body>");
out.println("<h1 align='center'>PLACE YOUR ORDER</h1>"); 
out.println("<hr />");
try {
Class.forName("com.mysql.cj.jdbc.Driver");
String URL = "jdbc:mysql://localhost:3306/cafe";
conn = DriverManager.getConnection(URL, "root", "venkatesh"); 
ps = conn.prepareStatement("insert coffee values (?, ?, ?, ?)");
ps.setInt(1, Integer.parseInt(request.getParameter("id")));
ps.setString(2, request.getParameter("name"));
ps.setInt(3, Integer.parseInt(request.getParameter("cost")));
ps.setInt(4, Integer.parseInt(request.getParameter("qty")));


int res = ps.executeUpdate();
if (res != 0)
out.println("<h1>YOUR ORDER HAS BEEN PLACED SUCCESSFULLY</h1>");
else
out.println("<h1>YOUR ORDER HAS NOT BEEN PLACED YET</h1>");
ps.close();
conn.close();
} catch (Exception e) { out.println(e);
}
out.println("<br />");
out.println("<a href='Product.html'><h2>BACK</h2></a>");
out.println("</body></html>");
}

}
