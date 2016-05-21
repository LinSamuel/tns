import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import java.util.*;

public class TestUntils {

	private static ArrayList<String> testList1;
	private static ArrayList<String> testList2;
	
	private static LinkedHashMap<String, String> testMap;
	
	@BeforeClass
	public static void onceExecutedBeforeAll() {
		testList1 = new ArrayList<String>();
		testList1.add("hello");
		testList1.add("world");
		testList1.add("abc");
		testList1.add(" ");
		
		testList2 = new ArrayList<String>();
		testList2.add("1");
		testList2.add("2");
		testList2.add("3");
		
		testMap = new LinkedHashMap<String, String>();
		testMap.put("a", "apple");
		testMap.put("b", "banana");
		testMap.put("c", "carrot");
	}

	@Test
	public void implode() {
		
		assertTrue( Utils.implode(",", testList1).equals("hello,world,abc") );
		assertTrue( Utils.implode(",", testList1, "`").equals("`hello`,`world`,`abc`") );
		
		assertTrue( Utils.implode("/ ", testList2).equals("1/ 2/ 3") );
		assertTrue( Utils.implode("/ ", testList2, "`").equals("`1`/ `2`/ `3`") );
	}
	
	@Test
	public void prepareQuestionmarks() {
		assert( Utils.prepareQuestionmarks(5).equals("(?,?,?,?,?)") );
		assert( Utils.prepareQuestionmarks(0).equals("()") );
		assert( Utils.prepareQuestionmarks(1).equals("(?)") );
	}
	
	@Test
	public void prepareStatement() {
		assertTrue( Utils.prepareStatement(testMap, "abc").equals(
				"INSERT INTO `abc` SET (`a`,`b`,`c`) VALUES (?,?,?)"
			)
		);
	}

}
