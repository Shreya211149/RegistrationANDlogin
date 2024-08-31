package in.rl.backend;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class loginForm
 */
public class loginForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String myemail=request.getParameter("email1");
		String mypass=request.getParameter("pass1");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Reg_login", "root", "Shreya@2002");
			PreparedStatement ps=con.prepareStatement("select * from register where email=? and password=?");
			ps.setString(1,myemail);
			ps.setString(2,mypass);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				HttpSession session=request.getSession();
				session.setAttribute("sess_name", rs.getString("name"));
				RequestDispatcher rd=request.getRequestDispatcher("/profile.jsp");
				rd.include(request, response);
			}
			else {
				
				out.print("<h3 style='color:red'>Invalid Credential.Check email and Password</h3>");
				RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
				rd.include(request, response);
			}
		
		}catch(Exception e) {
			e.printStackTrace();
			
			out.print("<h3 style='color:red'>e.getMessage()</h3>");
			RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
			rd.include(request, response);
		}
	}

}
