import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CodeForces133A {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		String line = in.readLine();
		if( line.contains("H")||line.contains("Q")||line.contains("9"))
			System.out.println("YES");
		else System.out.println("NO");
		
	}

}
