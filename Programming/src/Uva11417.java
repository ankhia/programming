

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Uva11417 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line; (line = in.readLine()) != null; ) {
			int n = Integer.parseInt(line);
			if(n==0)break;
			int G = 0;
			for (int i = 1; i < n; i++) {
				for (int j = i+1; j <= n; j++) {
					G += gcd(i,j);
				}
			}
			
			sb.append(G+"\n");
		}
		System.out.print(new String(sb));
	}

	private static long gcd(int i, int j) {
		if(j==0) return i;
		else return gcd(j, i%j);
	}
}
