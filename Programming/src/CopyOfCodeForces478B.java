import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class CopyOfCodeForces478B {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		for (String ln ; (ln = in.readLine())!=null; ) {
			StringTokenizer st = new StringTokenizer(ln);
			long n = Long.parseLong(st.nextToken());
			long cantG = Long.parseLong(st.nextToken());
			
			long repartir = Math.round( (double) n / (double) cantG );
			System.out.println(repartir);
					
			
			
		}
	}
	
	static BigInteger sumatoriaN ( BigInteger n ){
		return (n.multiply(n.subtract(BigInteger.ONE)).divide(BigInteger.valueOf(2)));
	}
}
