package tns;
import java.util.*;

/**
 * Utils
 * Helper Class
 * since we are using java 7 :(
 */
public class Utils {

	/**
	 * implode
	 * acts much like php's implode function
	 * 
	 * usage:
	 *   // listOfString = ["k", "thanks", "bye"]
	 *   String columns = Utils.implode("," listOfString);
	 * 	 // columns = "k,thanks,bye";
	 * 
	 * from:
	 *  http://stackoverflow.com/questions/11248119/java-equivalent-of-phps-implode-array-filter-array
	 * 
	 * @param delimiter {String}
	 * @param list {List}
	 * @return {String}
	 */
	public static String implode(String delimiter, List<String> list) {
		return Utils.implode(delimiter, list, "");
	}
	
	/**
	 * implode
	 * 
	 * overloaded for optional parameter
	 * 
	 * @param delimiter {String}
	 * @param list {List}
	 * @param optional {String}
	 * @return {String}
	 */
	public static String implode(String delimiter, List<String> list, String optional) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size() - 1; i++) {
			if (!list.get(i).matches(" *")) {//empty string are ""; " "; "  "; and so on
	            sb.append(optional);
				sb.append(list.get(i));
	            sb.append(optional);
	            sb.append(delimiter);
	        }
		}
		
		if ( ! list.get(list.size() - 1).matches(" *")) {
			sb.append(optional);
			sb.append( list.get(list.size()-1) );
			sb.append(optional);
		} else {
			sb.delete(sb.length() - delimiter.length(), sb.length());
		}

		return sb.toString();
	}
	
	/**
	 * prepareQuestionmarsk
	 * some code duplication, but not sure if creating an array (memory)
	 * is worth a small amount of code dup.
	 * 
	 * usage:
	 *   Utils.prepareQuestionmarks(3);
	 *   // returns "(?,?,?)"
	 * 
	 * @param size {int}
	 * @return {String}
	 */
	public static String prepareQuestionmarks(int size) {

		if (size <= 0) {
			return "()";
		}

		StringBuilder sb = new StringBuilder();
		
		sb.append("(");
		
		for (int i = 0; i < size - 1; i++) {
			sb.append("?");
			sb.append(",");
		}
		
		sb.append("?)");
		
		return sb.toString();
	}
	
	/**
	 * preparedStatement
	 * creates string ready for insertion
	 * 
	 * usage:
	 *   // Map map = {"a":"apple", "b":"banana", "c":"carrot"}
	 *   // String table = "abc"
	 *   Utils.prepareStatement(map, table)
	 *   // "INSERT INTO `abc` SET (`a`,`b`,`c`) VALUES (?,?,?)"
	 *   
	 * @param attributes {Map}
	 * @param table {String}
	 * @return {String}
	 */
	public static String prepareInsert(Map<String, String> attributes, String table) {
		// get columns and values as an array list
		List<String> columns = new ArrayList<String>(attributes.keySet());
		
		// build columns string
		String column = "(" + Utils.implode(",", columns, "`") + ")";
		
		// builds (?, ?, ?, ... ?)
		String value  = Utils.prepareQuestionmarks(attributes.size());

		String sql = "INSERT INTO `" + table + "` SET ";
		sql += column + " VALUES " + value;
		
		return sql;
	}
	
	/**
	 * prepareWhere - generates where statement
	 * 
	 * usage:
	 *   // map = {"abc":"123", "efg":"456"}
	 *   Utils.prepareWhere(map)
	 *   // returns "`abc` = ? AND `efg` = ? "
	 * @param map
	 * @return
	 */
	public static String prepareWhere(Map<String, String> map) {
		ArrayList<String> list = new ArrayList<String>();
		
		ArrayList<String> keys = new ArrayList<String>(map.keySet());
		
		for (String key : keys) {
			list.add("" + key + " = ?");
		}
		
		return Utils.implode(" AND ", list);
	}
	
	public static String prepareSelect(Map<String, String> attributes, String table) {
		List<String> columns = new ArrayList<String>(attributes.keySet());
		
		String sql = "SELECT * FROM `" + table + "` WHERE ";
		
		return "a";
	}
}
