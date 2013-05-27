import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva10943 {

	static int dp[][] = new int[102][102];

	static void dpM ( ){
		
		for (int i = 0; i < dp.length; i++) {
			dp[0][i] = 0;
			dp[i][0] = 1;
			dp[1][i] = 1;
		}
		for (int i = 2; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				dp[i][j] = (dp[i-1][j]%1000000+dp[i][j-1]%1000000)%1000000;
			}
		}
	}
	
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		dpM();
		for (String line; (line = in.readLine())!=null; ) {
			StringTokenizer st = new StringTokenizer(line);
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			if(n==0&&k==0)break;
			System.out.println(dp[k][n]);
		}
	}
}
