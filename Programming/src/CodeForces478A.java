import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CodeForces478A {

	static int n[];
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String line; (line = in.readLine())!=null;){
			StringTokenizer st = new StringTokenizer(line);
			int sum = 0;
			while( st.hasMoreTokens() )
				sum += Integer.parseInt(st.nextToken());
			if( sum != 0 && sum % 5 == 0 ) System.out.println(sum/5);
			else System.out.println(-1);
		}
	}
}
