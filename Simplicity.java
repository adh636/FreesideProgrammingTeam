import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Simplicity {
	static Map<Character, Integer> numChars = new HashMap<Character, Integer>();

	public static void main(String[] args) throws FileNotFoundException {
		/*
		Scanner in = new Scanner(new File("simplicity.txt"));
		while (in.hasNextLine()) {
			String test = in.nextLine();
			initializeHashMap(test);
			removeLargest(numChars);
			removeLargest(numChars);
			System.out.println(test + ": " + getOutput(numChars));
		}
		*/
		
		printSimplified("uncopyrightable");
	}
	
	public static void printSimplified(String input) {
		initializeHashMap(input);
		removeLargest(numChars);
		removeLargest(numChars);
		System.out.println(input + ": " + getOutput(numChars));
	}
	
	public static void initializeHashMap(String input) {
		char[] testArray = input.toCharArray();  
		for (char c: testArray) {
		    if (!numChars.containsKey(c)) numChars.put(c, 1);
		    else numChars.put(c, numChars.get(c) + 1);
		}
	}
	
	public static void removeLargest(Map<Character, Integer> charMap) {
		Character largestChar = '\0';
		int largestValue = 0;
		Iterator it = charMap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<Character, Integer> pair = (Map.Entry)it.next();
	        if ((int) pair.getValue() > largestValue) {
	        	largestValue = (int) pair.getValue();
	        	largestChar = (Character) pair.getKey();
	        }
	    }
	    numChars.remove(largestChar);
	}
	
	public static int getOutput(Map<Character, Integer> numChars) {
		int total = 0;
		for (int i: numChars.values()) {
			total += i;
		}
		return total;
	}
}
