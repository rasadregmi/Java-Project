import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        
        PrintWriter out=response.getWriter();  
          
        String mid=request.getParameter("id");  
        int id=Integer.parseInt(mid);  
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        String email=request.getParameter("email");  
        String country=request.getParameter("country");  
          
        Mem m=new Mem(); 
        MemD md=new MemD();
        
        m.setId(id);  
        m.setName(name);  
        m.setPassword(password);  
        m.setEmail(email);  
        m.setCountry(country);  
          
        int status = 0;
        
		try {
			status = md.update(m);
		} 
		catch (Exception e) {}
        
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  
