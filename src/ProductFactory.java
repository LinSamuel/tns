import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;




public class ProductFactory {
	public static ArrayList<Product> getProduct(HashMap<String,String> searchAttributes) throws SQLException{
		ResultSet rs = Database.queryHandler(searchAttributes);
		
		HashMap<String,Product> productMap = new HashMap<String,Product>();
		while(rs.next()){
			
			if(productMap.get(rs.getString("id")) != null){
				productMap.get(rs.getString("id")).addImage(rs.getString("url"));
			} else{
				Product newProduct = new Product();
				
				newProduct.setId(rs.getString("id"));
				newProduct.setBrand(rs.getString("brand"));
				newProduct.setName(rs.getString("name"));
				newProduct.setColor(rs.getString("color"));
				newProduct.setPrice(rs.getDouble("price"));
				newProduct.setDefaultImage(rs.getString("default_image"));
				newProduct.setSlug(rs.getString("slug"));
				newProduct.setDetails(rs.getString("details"));
				newProduct.addImage(rs.getString("url"));
				newProduct.setGender(rs.getString("gender"));
				newProduct.setCategory(rs.getString("category"));							
			}

		}
		ArrayList<Product> finalProducts = null;
		try{
			finalProducts = new ArrayList<Product>(productMap.values());
		} catch(Exception e){
			System.out.println("something went wrong");
		}
		return finalProducts;
	   }
}
