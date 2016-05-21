import java.sql.*;

public class Customer extends Database {
	private String id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	
	public String getId() {
		return id;
	}
	public void setId(String newId) {
		this.id = newId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String newLastName) {
		this.lastName = newLastName;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String newAddress) {
		this.address = newAddress;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String newCity) {
		this.city = newCity;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String newState) {
		this.state = newState;
	}
	
	public String getZip() {
		return zip;
	}
	public void setZip(String newZip) {
		this.zip = newZip;
	}
	
	public int save() {
		
		java.sql.PreparedStatement prepared;
		//connect
		String sql = "INSERT INTO `customers` "
				+ "(`first_name`, `last_name`, `address`, `city`, `state`, `zip`) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try {
			prepared = connection.prepareStatement(sql);
			
		} catch (SQLException e) {
			return 0;
		}
		return 1;
	}
}