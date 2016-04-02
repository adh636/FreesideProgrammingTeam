import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Twitter {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("TwitterInput.txt"));
		TreeMap<String, Integer> hashTags = getHashTags(in); // TreeMap to hold HashTag and counts
		printHashTags(hashTags);
	}
	
	public static TreeMap<String, Integer> getHashTags(Scanner in) {
		TreeMap<String, Integer> hashTags = new TreeMap<String, Integer>();
		while (in.hasNextLine()) {
			String[] current = in.nextLine().split(" "); // splits String into Array of Strings separated by spaces
			for (String s: current) { // iterates through each element of the Array
				if (s.substring(0, 1).equals("#")) { // look at Strings that start with #
					String lcString = s.substring(1).toLowerCase(); // get String after #
					if (!hashTags.containsKey(lcString)) {
						hashTags.put(lcString, 1); // if String not in TreeMap, add it with value of time
					}
					else {
						hashTags.put(lcString, hashTags.get(lcString) + 1); // else increment value by 1
					}
				}
			}
		}
		return hashTags; // return TreeMap with all HashTags and values
	}
	
	// print TreeMap key/value pairs in order
	public static void printHashTags(TreeMap<String, Integer> hashTags) {		
		for(Map.Entry<String,Integer> entry : hashTags.entrySet()) {
		    String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(value + " " + key);
		}
	}
}