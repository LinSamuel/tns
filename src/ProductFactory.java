import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;




public class ProductFactory {
	
	/**
	 * getProduct: This function is a static factory function that produces an ArrayList of Product objects depending on the
	 * search attributes that is passed in to be queried to the database
	 * 
	 * @param searchAttributes - A hashmap that contains the parameters that will be placed in the WHERE clause in the SQL query
	 * @param complexQueries - a boolean flag, if it is false, then each item in the hashmap is meant to be sent in separately to the
	 * database, with each item in the hashmap symbolizing a separate query. If complexQueries is true, then all of the items in the 
	 * searchAttributes HashMap is meant to be queries together
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Product> getProduct(HashMap<String,String> searchAttributes, boolean complexQueries) throws SQLException{
		ResultSet rs = null;
		HashMap<String,Product> productMap = new HashMap<String,Product>();
		
		if (complexQueries==false){

		Iterator iter = searchAttributes.entrySet().iterator();

		while(iter.hasNext()){
			HashMap<String,String> innerMap = new HashMap<String,String>();
			Map.Entry searchPair = (Map.Entry)iter.next();
			innerMap.put((String)searchPair.getKey(), (String)searchPair.getValue());
			rs = Database.queryHandler(innerMap);

			while(rs.next()){
				if(productMap.containsKey(rs.getString("id"))){
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
					productMap.put(rs.getString("id"), newProduct);
				}
	
			}
		
		}
		} else {
			rs = Database.queryHandler(searchAttributes);
			while(rs.next()){
				if(productMap.containsKey(rs.getString("id"))){
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
					productMap.put(rs.getString("id"), newProduct);
				}
	
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
	
	public static ArrayList<Product> getProductView(ArrayList<String> productIDList) throws SQLException{
		ResultSet rs = null;
		LinkedHashMap<String,Product> productMap = new LinkedHashMap<String,Product>();
		for(int i = 0; i < productIDList.size(); i++){
			HashMap<String,String> newHashMap = new HashMap<String,String>();
			newHashMap.put("p.id",productIDList.get(i));
			rs = Database.queryHandler(newHashMap);
			while(rs.next()){
				if(productMap.containsKey(rs.getString("id"))){
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
					productMap.put(rs.getString("id"), newProduct);
				}

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
