
public class SumOfPrimes {

	public static void main(String[] args) {
		System.out.println(sumOfPrimes(17));
		System.out.println(sumOfPrimes(18));
		System.out.println(sumOfPrimes(19));
		System.out.println(sumOfPrimes(20));
		
		long startTime = System.currentTimeMillis();
		System.out.println(sumOfPrimes(1000000000));
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		
		long startTime2 = System.currentTimeMillis();
		System.out.println(sumOfPrimes2(1000000000));
		long endTime2 = System.currentTimeMillis();
		System.out.println(endTime2-startTime2);
	}
	
	// return first set of primes that sum to the input number
	public static String sumOfPrimes(int num) {
		// checks if num-2 is prime, since 2 is the only even prime (that we know of...)
		if (isPrime(num - 2)) {
			return num + " = 2 + " + (num - 2);
		}
		
		// tests if num is odd.  if num is odd, it can't be the sum of 2 odd numbers
		else if (num % 2 != 0) {
			return num + " is impossible";
		}
		
		// tests each odd number in ascending order starting at 3 
		// to see if i and the difference between num and i are prime
		for (int i = 3; i < (num/2); i += 2) {
			if (isPrime(i)) {
				if (isPrime(num - i)) {
					return num + " = " + i + " + " + (num - i);
				}
			}
		}
		
		return num + " is impossible";
	}
	
	// test if number is prime
	public static boolean isPrime(int n) { 
	    if (n % 2 == 0) return false;
	    for (int i = 3; i * i <= n; i += 2) {
	        if (n % i == 0)
	            return false;
	    }
	    return true;
	}
	
	// return 2 primes with the largest product
	// same as sumOfPrimes except for loop starts at num/2 and decreases instead of 3 and increasing
	public static String sumOfPrimes2(int num) {
		if (isPrime(num - 2)) {
			return num + " = 2 + " + (num - 2);
		}
		else if (num % 2 != 0) {
			return num + " is impossible";
		}
		for (int i = (num/2) - 1; i > 3; i -= 2) {
			if (isPrime(i)) {
				if (isPrime(num - i)) {
					return num + " = " + i + " + " + (num - i);
				}
			}
		}
		return num + " is impossible";
	}
}
