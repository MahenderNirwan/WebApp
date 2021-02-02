package servlet1;
import java.sql.*;



public class LoginDao 
{
	String url ="jdbc:mysql://127.0.0.1:3306/clipboard";
	String uername= "root";
	String passsql ="pb11ax7769";
	public void exe( String sql) 
	{ 
	 try {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection c =  DriverManager.getConnection(url,uername,passsql);
		PreparedStatement st = c.prepareStatement(sql);
		//st.setString(1,uname);
		//st.setString(2,pass);
		int rs= st.executeUpdate();		
		 c.close(); 
		
	 	} catch (Exception e) {
	 		// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	
	}
	
	public ResultSet check( String sql) 
	{ 
	 try {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection c =  DriverManager.getConnection(url,uername,passsql);
		PreparedStatement st = c.prepareStatement(sql);
		//st.setString(1,uname);
		//st.setString(2,pass);
		ResultSet rs= st.executeQuery();
		
		if(rs.next())
		{ 
			return rs;
			
		}
		
		 c.close();  
	 	} catch (Exception e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
	  
	  return null;
	}
}
