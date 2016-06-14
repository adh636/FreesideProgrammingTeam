import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RepeatingCharacters {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("RepeatingCharacters.txt"));
		repeatCharacters(in);
	}
	
	// prints out a string with each character from the input repeat a specified number of times
	public static void repeatCharacters(Scanner in) {

		System.out.println(Integer.parseInt(in.nextLine()));
		
		while (in.hasNextLine()) {

			String[] inputArray = in.nextLine().split(" ");
			int setNum = Integer.parseInt(inputArray[0]); // specifies the number of the input set
			int repeatNum = Integer.parseInt(inputArray[1]); // specifies number of times each character will repeat
			String s = inputArray[2]; // specifies String to be modified
			
			StringBuilder repeatedString = new StringBuilder();

			// loops through each character in the String
			for (int i = 0; i < s.length(); i++) {
				String current = s.substring(i, i+1);
				
				// loops through the number of times the character needs to be repeated
				for (int j = 0; j < repeatNum; j++) {
					repeatedString.append(current);
				}
			}
			
			System.out.println(setNum + " " + repeatNum + " " + repeatedString.toString());
		}
	}
}