import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CodeForces467A {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int cant = 0;
		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(in.readLine());
			int pi = Integer.parseInt(st.nextToken());
			int qi = Integer.parseInt(st.nextToken());
			if( qi - pi >= 2 ){
				cant++;
			}
		}
		System.out.println(cant);
	}
}
