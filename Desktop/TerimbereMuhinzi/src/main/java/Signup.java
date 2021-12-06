

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
@MultipartConfig(maxFileSize = 16177215) 
public class Signup extends HttpServlet {
	   
	private String url="jdbc:mysql://localhost:3307/hospitalms";
	 private  String user="root";
   private  String pass="";
   private String drivename="com.mysql.cj.jdbc.Driver";
  
   // use regular Java objects to write the data to a file
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("full_name");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
	
		String password=request.getParameter("password");
		
		 InputStream inputStream = null; 
	         
	        // obtains the upload file part in this multipart request
	        Part filePart = request.getPart("file");
	        if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart.getInputStream();
	        }
				

	  

	    
	       
	        Connection conn = null; // connection to the database
	        String message = null;  // message will be sent back to client
	         
	        try {
	            // connects to the database
	            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	            conn = DriverManager.getConnection(url,user,pass);
	 
	            // constructs SQL statement
	            String sql = "INSERT INTO patient (id,name,address,city,gender,email,password,photo) values(?,?,?,?,?,?,?,?)";
	            PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setString(1, null);
	            statement.setString(2, name);
	            statement.setString(3, address);
	            statement.setString(4, city);
	            statement.setString(5, gender);
	            statement.setString(6, email);
	            statement.setString(7, password);
	            
	            
	            
	             
	            if (inputStream != null) {
	                // fetches input stream of the upload file for the blob column
	                statement.setBlob(8, inputStream);
	            }
	 
	            // sends the statement to the database server
	            int row = statement.executeUpdate();
	            if (row > 0) {
	                message = "File uploaded and saved into database";
	            }
	        } catch (SQLException ex) {
	            message = "ERROR: " + ex.getMessage();
	            ex.printStackTrace();
	        } finally {
	            if (conn != null) {
	                // closes the database connection
	                try {
	                    conn.close();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	            // sets the message in request scope
	            request.setAttribute("Message", message);
	             
	            // forwards to the message page
	            getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
	        }
	        try {
	        	 String[] rows = new String[1];
				FileWriter f=new FileWriter("C:\\Users\\Students\\Desktop\\nn.csv",true);
				BufferedWriter br=new BufferedWriter(f);
				PrintWriter pw=new PrintWriter(br);
//				pw.print(name);
//				pw.print(",");
//				pw.print(address);
//				pw.print(",");
//				pw.print(city);
//				pw.print(",");
//				pw.print(gender);
//				pw.print(",");
//				pw.print(email);
//				pw.print(",");
//				pw.print(password);
//				pw.print(",");
				  
			    for(int p = 1; p<rows.length; p++){
			      pw.append(rows[p]);
			    }
				
				pw.println(name+ ","+address+","+city+","+gender+","+email+","+password);
				
				pw.flush();
				f.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		
		
	}


