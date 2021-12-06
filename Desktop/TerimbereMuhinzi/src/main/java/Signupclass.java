import javax.servlet.http.Part;

public class Signupclass {

	private String name;
	private String address;
	private String city;
	private String gender;
	private String email;
	private String password;
	private Part file;
	public Signupclass(String name, String address, String city, String gender, String email, String password,
			Part filePart) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.file = filePart;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Part getFile() {
		return file;
	}
	public void setFile(Part file) {
		this.file = file;
	}
	
	
	

}
