package in.rl.backend;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class regForm
 */
public class regForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();	
		
		String myname=request.getParameter("name1");
		String myemail=request.getParameter("email1");
		String mypass=request.getParameter("pass1");
		String mygender=request.getParameter("gen1");
		String mycity=request.getParameter("city1");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Reg_login", "root", "Shreya@2002");
			PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?)");
			ps.setString(1,myname);
			ps.setString(2,myemail);
			ps.setString(3,mypass);
			ps.setString(4,mygender);
			ps.setString(5,mycity);
			
			int rowAffect=ps.executeUpdate();
			if(rowAffect>0) {
				response.setContentType("text/html");
				out.print("<h3 style='color:green'>User registered succesfully</h3>");
				RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
				rd.include(request, response);
				
			}
			else {
				response.setContentType("text/html");
				out.print("<h3 style='color:red'>User not registered due to some error</h3>");
				
				RequestDispatcher rd=request.getRequestDispatcher("/register.jsp");
				rd.include(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
			response.setContentType("text/html");
			out.print("<h3 style='color:red'>Exception occurred:"+e.getMessage()+"</h3>");
			
			RequestDispatcher rd=request.getRequestDispatcher("/register.jsp");
			rd.include(request, response);
			
		}
	}

}
