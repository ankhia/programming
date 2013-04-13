import java.io.*;
import java.util.StringTokenizer;


public class Uva10496 {

	static int[][] mat ;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int scen = Integer.parseInt(in.readLine());	
		for (int t = 0; t < scen; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			mat = new int[n][m];
			
		}
	}

}
