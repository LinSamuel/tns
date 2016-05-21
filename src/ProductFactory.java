import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;




public class ProductFactory {
	public static ArrayList<Product> getProduct(HashMap<String,String> searchAttributes) throws SQLException{
		ResultSet rs = Database.queryHandler(searchAttributes);
		
		HashMap<String,Product> productMap = new HashMap<String,Product>();
		while(rs.next()){
			System.out.println("adding new product..");
			
			//Product p = productMap.get(rs.getString("id"));
			if(productMap.containsKey(rs.getString("id"))){
				System.out.println("in 1");
				productMap.get(rs.getString("id")).addImage(rs.getString("url"));
				System.out.println(rs.getString("url"));
			} else{
				Product newProduct = new Product();
				System.out.println("in 2");
				System.out.println(rs.getString("default_image"));
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
				productMap.put(rs.getString("id"), newProduct);
			}

		}
		ArrayList<Product> finalProducts = null;
		try{
			finalProducts = new ArrayList<Product>(productMap.values());
			//System.out.println("new final");
//		    Iterator it = productMap.entrySet().iterator();
//		    while (it.hasNext()) {
//		        Map.Entry pair = (Map.Entry)it.next();
//		        finalProducts.add((Product) pair.getValue());
//		        it.remove(); // avoids a ConcurrentModificationException
//		    }
		} catch(Exception e){
			System.out.println("something went wrong");
		}
		return finalProducts;
	   }
}
