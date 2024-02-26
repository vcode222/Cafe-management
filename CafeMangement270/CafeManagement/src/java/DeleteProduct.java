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
* Servlet implementation class DeleteCustomer
*/ @WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet
{ private static final long serialVersionUID = 1L; Connection conn = null;
PreparedStatement ps = null;
/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub response.setContentType("text/html"); 
PrintWriter out = response.getWriter(); out.println("<html>");
out.println("<head><title>REMOVE ORDER</title></head>");
out.println("<style> body{background-color:#EADDCA;background-repeat: no-repeat;background-size: cover;background-attachment: fixed;</style>");
out.println("<body>");
out.println("<h1 align='center'>REMOVE ORDER</h1>"); out.println("<hr />");
try {
Class.forName("com.mysql.cj.jdbc.Driver");
String URL = "jdbc:mysql://localhost:3306/cafe";
conn = DriverManager.getConnection(URL, "root", "venkatesh"); 
ps = conn.prepareStatement("delete from coffee where id = ?"); 
ps.setInt(1, Integer.parseInt(request.getParameter("id")));
int res = ps.executeUpdate();
if (res != 0)
out.println("<h1>YOUR ORDER HAS BEEN REMOVED SUCCESSFULLY.</h1>");
else
out.println("<h1>FAILED!! CAN'T REMOVE YOUR ORDER.</h1>");
ps.close();
conn.close();
} catch (Exception e) { out.println(e);
}
out.println("<br />");
out.println("<a href='ViewProduct'>BACK</a>"); out.println("</body></html>");
}
}