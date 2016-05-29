import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class LastAccessMap {
	private HashMap<String,Date> lastMap;
	
	public LastAccessMap(){
		this.lastMap = new HashMap<String,Date>();
	}

	public HashMap<String,Date> getLastMap() {
		return lastMap;
	}

	public void setLastMap(HashMap<String,Date> lastMap) {
		this.lastMap = lastMap;
	}
	
	public void addAccessTime(String sessionID, Date theDate){
		
		if (lastMap.get(sessionID) == null) {
			lastMap.put(sessionID, null);
		} 
		lastMap.put(sessionID, theDate);
		System.out.println("putting.. " + theDate.toString());
	}
	
	/**
	 * This method takes in the date (the time of the AJAX call) and compares that time with
	 * the other times stored in the map. If the difference between the time is 10 seconds or less,
	 * then the user is assumed to still be viewing the page, and a counter is incremented. If not, 
	 * that entry is counted as null and the user with that session id is assumed to be not viewing
	 * the page anymore
	 * 
	 * @param currentDate
	 * @return String
	 */
	public String checkTimes(Date currentDate){
		String currentViewers = null;
		
	    Iterator it = this.lastMap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        Date theLastAccess = (Date)pair.getValue();
	        int secondsDiff = (int) ((currentDate.getTime()-theLastAccess.getTime())/1000);
	        if(secondsDiff>10){
	        	it.remove();
	        }
	    }		
		System.out.println("current viewerss: " + String.valueOf(this.lastMap.size()));
		currentViewers = String.valueOf(this.lastMap.size());
		return currentViewers;
	}

}
