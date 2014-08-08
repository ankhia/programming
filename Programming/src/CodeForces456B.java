import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class CodeForces456B {
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BigInteger n = new BigInteger(in.readLine());
		System.out.println(n.mod(BigInteger.valueOf(4)).equals(BigInteger.ZERO)?4:0);
	}
}
