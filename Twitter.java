import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Twitter {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("TwitterInput.txt"));
		TreeMap<String, Integer> hashTags = getHashTags(in);
		printHashTags(hashTags);
	}
	
	public static TreeMap<String, Integer> getHashTags(Scanner in) {
		TreeMap<String, Integer> hashTags = new TreeMap<String, Integer>();
		while (in.hasNextLine()) {
			String[] current = in.nextLine().split(" ");
			for (String s: current) {
				if (s.length() > 0) {
					if (s.substring(0, 1).equals("#")) {
						String lcString = s.substring(1).toLowerCase();
						if (!hashTags.containsKey(lcString)) {
							hashTags.put(lcString, 1);
						}
						else {
							hashTags.put(lcString, hashTags.get(lcString) + 1);
						}
					}
				}
			}
		}
		return hashTags;
	}
	
	public static void printHashTags(TreeMap<String, Integer> hashTags) {		
		for(Map.Entry<String,Integer> entry : hashTags.entrySet()) {
		    String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(value + " " + key);
		}
	}
}