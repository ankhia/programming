import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CodeForces116A {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln; (ln=in.readLine())!=null; ){
			int n = Integer.parseInt(ln);
			int cantMax=0;
			int totalGente = 0;
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int salen = Integer.parseInt(st.nextToken());
				int entran = Integer.parseInt(st.nextToken());
				if( totalGente > 0 ) 
					totalGente -= salen;
				totalGente+=entran;
				if( totalGente > cantMax ) cantMax = totalGente;
			}
			System.out.println(cantMax);
		}
	}
}
