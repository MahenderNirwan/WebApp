<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@page import="java.sql.*"%>
<%@page import="servlet1.LoginDao" %>
<head>

<title>Insert title here</title>
</head>
<body style="background-color:rgb(255, 255, 237);">
		<%
		if(session.getAttribute("UserName")==null)
		{
			response.sendRedirect("Index.html");
		}
		LoginDao dao = new LoginDao();
		ResultSet rs = dao.check("select * from board");
		rs.previous();
	
		%>
		Welcome ${UserName} To Msb's clipboard
		<table border=1 width=50% height=50%>
		<thead>
          <tr>
             <th>1</th>
             <th>2</th>
             <th>3</th>
             <th>4</th>
          </tr>
       </thead>
       <tbody>
  <% while(rs.next())
        {rs.previous(); %>
		 <tr>
		 <% for(int i=0; i<4 && rs.next();i++)
           {%>
                <td><span style="font-weight: bold"><%=rs.getString("message") %></span><br>     -<%=rs.getString("uname") %></td>
         <%}%> 
	      </tr>
       <%}%>
            
      </tbody>
		</table>
		  <form action="adding_message.jsp">
		  Message:  <input type="text" name="m" value="" required>
		  <input type="submit" value="Submit " name="b1" />
		   </form>
		  
           

</body>
</html>