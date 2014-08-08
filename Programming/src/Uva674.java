

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Uva674 {

	static int [] coins = new int[]{50,25,10,5,1};
	static long [] sol;
 	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sol = new long[10000];
		solve();
		for (String line; (line = in.readLine())!= null; ) {
			int n = Integer.parseInt(line.trim());
			sb.append(sol[n]+"\n");
		}
		System.out.print(new String(sb));
	}
	
	public static void solve( ){
		sol[0]=1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = 0; j < sol.length; j++) {
				if(j+coins[i]<sol.length)
					sol[j+coins[i]] += sol[j];
			}
		}
	}

}
