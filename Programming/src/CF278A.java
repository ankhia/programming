import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CF278A {

	static int[ ] m;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine( ));
		m = new int[n+n+n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++){ 
			m[i] = Integer.parseInt(st.nextToken( ));
			m[i+n] = m[i];
			m[i+n+n] = m[i];
		}
		st = new StringTokenizer(in.readLine());
		int a = Integer.parseInt(st.nextToken( ));
		int b = Integer.parseInt(st.nextToken( ));
		int s = Math.min(a, b);
		int t = Math.max(a, b);
		int sum = 0;
		for (int i = (s-1)+n; i < (t-1)+n; i++) {
			sum+=m[i];
		}
		int sum2 = 0;
		for (int i = t-1; i < (s-1)+n; i++) {
			sum2+=m[i];
		}
		if(sum > sum2)
			System.out.println(sum2);
		else System.out.println(sum);
	}

}
