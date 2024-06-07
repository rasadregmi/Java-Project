import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	PrintWriter out = response.getWriter();
    	RequestDispatcher rd=request.getRequestDispatcher("/index.html");

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        Mem m = new Mem();
        m.setName(name);
        m.setPassword(password);
        m.setEmail(email);
        m.setCountry(country);

        MemD md = new MemD();
        int status = 0;
		try {
			status = md.save(m);
		} 
		catch(Exception e) {}
		
        if (status > 0) {
            out.print("<p>Record is saved successfully!</p>");
            rd.include(request, response);
        } 
        else {
            out.println("Sorry! Record is not saved!");
        }
        out.close();
    }
}
