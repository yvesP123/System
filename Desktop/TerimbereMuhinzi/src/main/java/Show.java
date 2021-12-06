import java.io.ByteArrayOutputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.sql.Blob;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.Base64;

import org.apache.catalina.User;
public class Show
{

	 
	
	String databaseURL = "jdbc:mysql://localhost:3307/hospitalms";
	String user = "root";
	String password = "pass";
	 
	public User get(int id) throws SQLException, IOException {
	User user = null;
	 
	String sql = "SELECT * FROM user_tbl WHERE user_id = ?";
	 
	try (Connection connection = DriverManager.getConnection(databaseURL, user, password)) {
	PreparedStatement statement = connection.prepareStatement(sql);
	statement.setInt(1, id);
	ResultSet result = statement.executeQuery();
	 
	if (result.next()) {
	user = new User();
	String username = result.getString("username");
	String email = result.getString("email");
	Blob blob = result.getBlob("image");
	 
	InputStream inputStream = blob.getBinaryStream();
	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	byte[] buffer = new byte[4096];
	int bytesRead = -1;
	 
	while ((bytesRead = inputStream.read(buffer)) != -1) {
	outputStream.write(buffer, 0, bytesRead);
	}
	 
	byte[] imageBytes = outputStream.toByteArray();
	String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	 
	inputStream.close();
	outputStream.close();
	 
	user.setUsername(username);
	book.setEmail(email);
	book.setProfileImg(base64Image);
	}
	 
	} catch (SQLException | IOException ex) {
	ex.printStackTrace();
	throw ex;
	}
	 
	return user;
	}
	}

}
