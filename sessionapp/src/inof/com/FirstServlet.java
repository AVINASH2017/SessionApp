package inof.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FirstServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("name");
		Double sal = Double.parseDouble(request.getParameter("sal"));
		HttpSession session = request.getSession();
		session.setAttribute("user",user);
		session.setAttribute("salary",sal);
		PrintWriter out = response.getWriter();
		out.println("<form action='http://localhost:2017/sessionapp/second'> ");
		out.println("<input type='submit' value='next'/></form>");
		
		out.println(user+"............."+sal);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
