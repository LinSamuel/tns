import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Product {
	private String id;
	private String brand;
	private String name;
	private String color;
	private double price;
	private String[] images;
	private	String defaultImage;
	private String slug;
	private String details;
	private String gender;
	private String category;
	
	//Getters and setters for attributes
	public void setId(String newId) {
		id = newId;
	}
	
	public String getId() {
		return id;
	}
	
	public void setBrand(String newBrand) {
		brand = newBrand;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setColor(String newColor) {
		color = newColor;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setPrice(double newPrice) {
		price = newPrice;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setImages(String[] newImages) {
		for(int i = 0; i < newImages.length; i++) {
			images[i] = newImages[i];
		}
	}
	
	public String[] getImages() {
		return images;
	}
	
	public void setDefaultImage(String newDefaultImage) {
		defaultImage = newDefaultImage;
	}
	
	public String getDefaultImage() {
		return defaultImage;
	}
	
	public void setSlug(String newSlug) {
		slug = newSlug;
	}
	
	public String getSlug() {
		return slug;
	}
	
	public void setDetails(String newDetails) {
		details = newDetails;
	}
	
	public String getDetails() {
		return details;
	}
	
	public void setGender(String newGender) {
		gender = newGender;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setCategory(String newCategory) {
		category = newCategory;
	}
	
	public String getCategory() {
		return category;
	}
	
	
	// Incorporate mySQL driver
	public static void queryDatabase() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	// Connect to the test database
	Connection connection = DriverManager.getConnection("jdbc:mysql:///tnsdb","mytestuser", "mypassword");
	
	
	connection.close();
}
	
	
}
