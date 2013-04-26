

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/external/113/11349.html
 * @veredict  
 * @problemId 11349
 * @problemName  Symmetric Matrix
 * @judge http://uva.onlinejudge.org/
 * @category --
 * @level easy
 * @date 11/07/2012
 **/

public class Uva11349 {

	static long mat[][];
	
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cases = parseInt(in.readLine()); 
		for (int casos = 0; casos < cases; casos++) {
			int n = parseInt(in.readLine().split(" ")[2]);
			mat = new long[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < n; j++) {
					mat[i][j] = parseLong(st.nextToken());
				}
			}
			
			boolean symmetric = true;
			for (int i = 0; i < mat.length && symmetric; i++) {
				for (int j = 0; j < mat.length; j++) {
					if(i!=j)
						if(mat[i][j] != mat[j][i])
							symmetric=false;
				}
			}
			
			if(symmetric)
				System.out.println("Test #"+(casos+1)+": Symmetric.");
			else
				System.out.println("Test #"+(casos+1)+": Non-symmetric.");
		}
	}

}
