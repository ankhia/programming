import java.util.ArrayList;
import java.util.List;


public class Uva1213 {

	static boolean isPrime[];
	static List<Integer> primes;
	
	static int[] waysByNumber;
	public static void main(String[] args) {
		isPrime = new boolean[1100];
		primes = new ArrayList<Integer>();
		init( );
		for(Integer i : primes)
			System.out.print(i+" ");
	}
	
	public static void init( ){
		for (int i = 2; i < 1000; i++) {
			if( !isPrime[i] ){
				for (int j = i*i; j < 1000; j+=i) {
					isPrime[j] = true;
				}
				primes.add(i);
			}
		}
		
	}

}
