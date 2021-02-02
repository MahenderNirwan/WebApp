<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="servlet1.LoginDao" %>
    <%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
		if(session.getAttribute("UserName")==null)
		{
			response.sendRedirect("Index.html");
		}
		LoginDao dao = new LoginDao();
		ResultSet rs = dao.check("select * from board");
		rs.previous();
	
		%>
  <%
                 
           
            	 String message = request.getParameter("m");
  					message=message.replace("'","''");
            	 String uname=(String)session.getAttribute("UserName");
            	 String sql = "insert into board values('" + uname  + "','" + message + "')";
            	 
            	 LoginDao dao2 = new LoginDao();
            	 dao2.exe(sql);
            	 System.out.println(sql);
            	 response.sendRedirect("welcome.jsp");
          %>
</body>
</html>