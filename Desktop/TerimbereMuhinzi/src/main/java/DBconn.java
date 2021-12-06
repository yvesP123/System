import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

import org.apache.catalina.filters.CsrfPreventionFilter;

public class DBconn {

	
	
		private String url="jdbc:mysql://localhost:3307/hospitalms";
		 private  String user="root";
	    private  String pass="";
	    private String drivename="com.mysql.cj.jdbc.Driver";
	    public void loaddrive(String dbDriver) 
	    {
	    	try {
				Class.forName(dbDriver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    		
	    }
	    public Connection getconnection() 
	    
	    {
	    	
	    	Connection conn=null;
	    	try {
				conn= DriverManager.getConnection(url,user,pass);
				//  PreparedStatement ps=conn.prepareStatement("insert into student(regnumber,fullname,age,gender)values(?,?,?,?)");
			       
			        
			} catch (SQLException e) {
		
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
	    	
	    }
	    public String insert(Signupclass sc) 
	    {
	    	String msg;
	    	loaddrive(drivename);
	    	Connection conn;
	    	conn=getconnection();
	    	msg="Data has been sent";
	    	
	    	 PreparedStatement ps=null;
	    	 FileInputStream fis=null;
	    	 String sql="insert into patient VALUES(?,?,?,?,?,?,?,?)";
	    	 try {
	    		 File image=new File();
				ps=conn.prepareStatement(sql);
				ps.setString(1, null);
				ps.setString(2, sc.getName());
				ps.setString(3, sc.getAddress());
				ps.setString(4,sc.getCity());
				ps.setString(5, sc.getGender());
				ps.setString(5, sc.getEmail());
				ps.setString(5, sc.getPassword());
				ps.setString(5, sc.getGender());
				fis=new FileInputStream(image);
				pstmt.setBinaryStream(3, (InputStream) fis, (int) (image.length()));
				ps.executeUpdate();
			} catch (SQLException e) {
				msg="error in the sql";
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 

	 		return msg;
	    }
	    
	}


