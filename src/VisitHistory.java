import java.util.LinkedHashMap;


public class VisitHistory {
	private LinkedHashMap<String, Product> visitHistory = new LinkedHashMap<String,Product>(10, .8f, true);
	
	public void addVisitedProduct(Product productToAdd) {
		visitHistory.put(productToAdd.getId(), productToAdd);

		if(visitHistory.size() > 5){
			System.out.println("deleting 1");
			this.visitHistory.remove(this.visitHistory.entrySet().iterator().next().getKey());
		}
	}
	
	public LinkedHashMap<String,Product> getVisitHistory(){
		return this.visitHistory;

	}
	
}
