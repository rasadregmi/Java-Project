import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;  
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        
        PrintWriter out=response.getWriter();  
        
        out.println("<h1 style='text-align:center;'>Members Detail</h1>");  
          
        MemD md=new MemD();
        
        List<Mem> list = null;
		try {
			list = md.getAllMembers();
		} 
		catch (Exception e) {}  
          
        out.print("<table border='1' width='100%' style='text-align:center;'");  
        out.print("<tr><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");  
        for(Mem m:list){  
         out.print("<tr><td>"+m.getName()+"</td><td>"+m.getPassword()+"</td><td>"+m.getEmail()+"</td><td>"+m.getCountry()+"</td><td><a href='EditServlet?id="+m.getId()+"'>Edit</a></td><td><a href='DeleteServlet?id="+m.getId()+"'>Delete</a></td></tr>");  
        }  
        out.print("</table>");  
        
        out.println("<br><br><a href='index.html'>Register New Member</a>");  
          
        out.close();  
    }  
}  