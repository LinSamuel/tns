import java.util.HashMap;


public class CurrentViewNum {
	private HashMap<String,Integer> viewCountMap;
	
	public CurrentViewNum(){
		this.viewCountMap  = new HashMap<String,Integer>();
		for(int i = 1; i < 21; i++){
			viewCountMap.put(String.valueOf(i), 0); //Initialize the map
		}
	}

	public HashMap<String,Integer> getViewCountMap() {
		return viewCountMap;
	}

	public void setViewCountMap(HashMap<String,Integer> viewCountMap) {
		this.viewCountMap = viewCountMap;
	}
	
	public void increaseCount(String productID){
		this.viewCountMap.put(productID, this.viewCountMap.get(productID) + 1);
	}
	
	public Integer getCurrentCount(String productID){
		return this.viewCountMap.get(productID);
	}
	
	
}
