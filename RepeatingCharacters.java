import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RepeatingCharacters {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("RepeatingCharacters.txt"));
		repeatCharacters(in);
	}
	
	public static void repeatCharacters(Scanner in) {
		System.out.println(Integer.parseInt(in.nextLine()));
		
		while (in.hasNextLine()) {
			String[] inputArray = in.nextLine().split(" ");
			int setNum = Integer.parseInt(inputArray[0]);
			int repeatNum = Integer.parseInt(inputArray[1]);
			String s = inputArray[2];
			
			StringBuilder repeatedString = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				String current = s.substring(i, i+1);
				
				for (int j = 0; j < repeatNum; j++) {
					repeatedString.append(current);
				}
			}
			System.out.println(setNum + " " + repeatNum + " " + repeatedString.toString());
		}
	}
}