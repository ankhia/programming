import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Codeforces460A {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = n;
		int max = n/m;
		n += max;
		while( n/m != max ){
			max = Math.max(max, n/m);
			n = t+max;
		}
		System.out.println(n);
	}
}
