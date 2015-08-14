import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Uva10405 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		for (String x; (x=in.readLine())!=null;) {
			String  y = in.readLine( );
			int cont = LCS(x.toCharArray(), y.toCharArray());
			sb.append(cont+"\n");	
		}
		System.out.print(new String(sb));
	}

	//Longest Common Subsequence 
	public static int LCS(char[] x, char[] y){
		int m = x.length;
		int n = y.length;
		int[][] C = new int[m+1][n+1];
		for(int i = 1; i < m+1; i++ ){
			for(int j = 1; j < n+1;j++ ){
				if( x[i-1] == y[j-1] )
					C[i][j] = C[i-1][j-1] + 1;
				else
					C[i][j] = max(C[i][j-1], C[i-1][j]);
			}
		}
		int max = 0;
		for (int i = 0; i < C[C.length-1].length; i++) {
			max = max(max, C[C.length-1][i]);
		}
		return max;
	}
}