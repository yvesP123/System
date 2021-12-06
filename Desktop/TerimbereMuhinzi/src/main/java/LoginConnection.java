
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginConnection {

	
	    public static boolean CheckCredentail(String uname,String pass) 
	    
	    {
	    	boolean s=false;
	    	
	    	        try {

	    	            
	    	            Class.forName("com.mysql.cj.jdbc.Driver");

	    	           
	    	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/hospitalms","root","");
	    	            PreparedStatement ps = con.prepareStatement("select * from patient where email=? and password=?");
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
