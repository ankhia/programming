import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CodeForces96A {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String line; (line = in.readLine())!= null; ) {
			if( line.contains("1111111") || line.contains("0000000") )
				System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
