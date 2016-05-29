import java.util.Date;
import java.util.HashMap;
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
		int peopleCounter = 0;
		for(Map.Entry<String,Date> entry: lastMap.entrySet()){
			Date theLastAccess = entry.getValue();
			int secondsDiff = (int) ((currentDate.getTime()-theLastAccess.getTime())/1000);
			System.out.println(secondsDiff);
			if (secondsDiff > 10){
				lastMap.put(entry.getKey(), null);
				continue;
			}
			peopleCounter++;			
		}
		System.out.println("current viewers: " + String.valueOf(peopleCounter));
		return currentViewers;
	}

}