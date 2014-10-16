import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class CodeForces478B {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		for (String ln ; (ln = in.readLine())!=null; ) {
			StringTokenizer st = new StringTokenizer(ln);
			int n = Integer.parseInt(st.nextToken());
			int cantG = Integer.parseInt(st.nextToken());

			long repartir = (long) Math.round( (double)n / (double) cantG );
			BigInteger nMin = sumatoriaN(BigInteger.valueOf(repartir)).multiply(BigInteger.valueOf(cantG-1));
			BigInteger faltan =  BigInteger.valueOf(n).subtract(BigInteger.valueOf(repartir).multiply(BigInteger.valueOf(cantG-1)));
			nMin = nMin.add(sumatoriaN(faltan));
			
			long nN = ( n - (cantG-1) );
			BigInteger max = sumatoriaN(BigInteger.valueOf(nN));
			System.out.println(nMin +" "+ max);
		}
	}
	
	static BigInteger sumatoriaN ( BigInteger n ){
		return (n.multiply( n.subtract(BigInteger.ONE) )).divide(BigInteger.valueOf(2));
	}
}
