import java.util.ArrayList;


public class VisitHistory {
	private ArrayList<String> visitHistory = new ArrayList<String>();

	public ArrayList<String> getVisitHistory() {
		return visitHistory;
	}

	public void setVisitHistory(ArrayList<String> visitHistory) {
		this.visitHistory = visitHistory;
	}
	
	public void addVisitedProduct(String productID) {
		if(visitHistory.size() >= 5){
			visitHistory.remove(0);
		}
		visitHistory.add(productID);
	}
	
}
