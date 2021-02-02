package servlet1;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String uName= request.getParameter("uName");
	String Password= request.getParameter("Password");
	LoginDao dao = new LoginDao();
	
	PrintWriter out = response.getWriter();  
	try {
		String sql="select * from login where uname = "+"'"+uName+"'"+" and "+"pass="+"'"+Password+"'";
	ResultSet rs = dao.check(sql);
	if(rs != null)
	{
		HttpSession session= request.getSession();
		session.setAttribute("UserName", uName);
		response.sendRedirect("welcome.jsp");
	}else
	
	{
		response.sendRedirect("Index.html");
	}
	
	}catch (Exception e) 
    {  
        out.println("error");  
    }  
}
}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/


