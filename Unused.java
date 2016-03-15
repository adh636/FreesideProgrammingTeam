import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Unused {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("Unused.txt"));	
		int counter = 1;
		while (in.hasNextLine()) {
			System.out.println("Letters missing in case #" + counter + ": " + printUnused(in.nextLine()));
			counter++; // increment counter for each test case
		}
	}
	
	// print all characters which were not used in the input String
	public static String printUnused(String s) {
		String condensed = s.replaceAll("\\s","").toLowerCase(); // remove whitespace and make lower case
		boolean[] chars = new boolean[26]; // boolean array for a-z
		StringBuilder output = new StringBuilder();
		
		for (int i = 0; i < condensed.length(); i++) {
			int current = (int) condensed.charAt(i); // ASCII value of current char
			chars[current - 97] = true; // sets index of current char to true
		}
		
		for (int j = 0; j < chars.length; j++) {
			if (!chars[j]) { // if array value is false, append char to output
				output.append(Character.toString((char) (j + 97)));
			}
		}		
		return output.toString();
	}	
}