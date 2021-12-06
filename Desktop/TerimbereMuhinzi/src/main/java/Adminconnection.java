import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Adminconnection 
{
	 public static boolean CheckCredentail(String uname,String pass) 
	    
	    {
	    	boolean s=false;
	    	
	    	        try {

	    	            
	    	            Class.forName("com.mysql.cj.jdbc.Driver");

	    	           
	    	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/hospitalms","root","");
	    	            PreparedStatement ps = con.prepareStatement("select * from admin where username=? and password=?");
	    	            ps.setString(1, uname);
	    	            ps.setString(2, pass);
	    	            ResultSet rs =ps.executeQuery();
	    	            s= rs.next();

	    	        }
	    	        catch(Exception e) {
	    	            e.printStackTrace();
	    	        }
	    	

	    	return s;
	    }
	   
	    

}
