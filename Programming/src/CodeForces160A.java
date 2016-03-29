import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CodeForces160A {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln ; (ln=in.readLine())!=null; ){
			int n = Integer.parseInt(ln);
			int[] coins = new int[n];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < coins.length; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(coins);
			int sum[] = new int[n];
			sum[coins.length-1] = coins[coins.length-1];
			for (int i = coins.length-1; i >= 0 ; i-- ) {
				if(i+1 < coins.length)
					sum[i] = coins[i]+sum[i+1];
			}
			
			boolean found = false;
			int c = 0;
			for (int i = coins.length-1; i >= 0 && !found; i--) {
				if( sum[i] > sum[0]-sum[i] ){
					c++;
					found = true;
				}else{
					c++;
				}
			}
			System.out.println(c);
			
		}
			
	}
}
