
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Uva495 {
	
	static BigInteger[] fib;
	public static void main( String[] args ) throws Throwable {
		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
		StringBuilder sb = new StringBuilder( );
		fib = new BigInteger[5002];
		calcularFibonacci( );
		for (String line; (line = in.readLine())!=null; ) {
			int calc = Integer.parseInt(line);
			sb.append("The Fibonacci number for "+calc+" is "+fib[calc]+"\n");
		}
		System.out.print(new String(sb));
	}
	
	private static void calcularFibonacci() {
		fib[0] = BigInteger.ZERO ;
		fib[1] = BigInteger.ONE;
		for (int i = 2; i < fib.length; i++) {
			fib[i] = fib[i-1].add(fib[i-2]);
		}
	}
}
