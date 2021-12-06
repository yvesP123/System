

import java.io.IOException;
import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
 
@WebServlet("/logout")
public class logout extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public logout() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	  response.setContentType("text/html");  
          PrintWriter out=response.getWriter();  
            
          request.getRequestDispatcher("Admin.jsp").include(request, response);  
            
          HttpSession session=request.getSession();  
          session.invalidate();  
            
          out.print("You are successfully logged out!");  
            
          out.close();  
    }
}
