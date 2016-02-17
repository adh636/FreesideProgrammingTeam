
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
	
	// return first set of primes
	public static String sumOfPrimes(int num) {
		if (isPrime(num - 2)) {
			return num + " = 2 + " + (num - 2);
		}
		else if (num % 2 != 0) {
			return num + " is impossible";
		}
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
