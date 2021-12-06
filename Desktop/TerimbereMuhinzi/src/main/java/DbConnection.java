  import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnection
{
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
    public String insert(ContactUs cu) 
    {
    	String msg;
    	loaddrive(drivename);
    	Connection conn;
    	conn=getconnection();
    	msg="Data has been sent";
    	
    	 PreparedStatement ps=null;
    	 String sql="insert into contactus VALUES(?,?,?,?,?)";
    	 try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, null);
			ps.setString(2, cu.getName());
			ps.setString(3, cu.getEmail());
			ps.setString(4, cu.getPhone());
			ps.setString(5, cu.getMessage());
			ps.executeUpdate();
		} catch (SQLException e) {
			msg="error in the sql";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 

 		return msg;
    }
    
}
