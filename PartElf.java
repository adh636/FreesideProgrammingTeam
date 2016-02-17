import java.io.File;
import java.util.Scanner;

public class PartElf {
	static int counter = 1;
	
	public static void main(String[] args) throws Exception {
		/*
	    Scanner in = new Scanner(new File("ElfInput.txt"));
	    while (in.hasNextLine()) {
	    	String current = in.nextLine();
	    	solve(current);
	    	counter++;
	    }
	    */
		
		String partElf = "123/31488";
		minGenerations(partElf);
	    }

    static int greatestCommonDenominator(int a, int b) {
        if (b == 0) {
            return a;
        }
        return greatestCommonDenominator(b, a % b);
    }

    static void minGenerations(String input) {
    	String[] pq = input.split("/");
    	int p = Integer.parseInt(pq[0]);
    	int q = Integer.parseInt(pq[1]);
        int gcd = greatestCommonDenominator(p, q);
        p /= gcd;
        q /= gcd;
        
        int result = 0;
        while (q > p) {
			p *= 2;
			result++;
		}
        
        if (p * Math.min(2, 40) % q == 0) {
        	System.out.println("Case #" + counter + ": " + result);
        }
        else {
        	System.out.println("Case #" + counter + ": impossible");
        }
    }  
}