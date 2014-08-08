

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva11764 {

	static int[] h;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		int t = Integer.parseInt(in.readLine());
		for (int c = 0; c < t; c++) {
			int walls = Integer.parseInt(in.readLine());
			h = new int[walls];
			StringTokenizer st = new StringTokenizer(in.readLine());
			int ini = Integer.parseInt(st.nextToken());
			int high = 0, low = 0;
			for (int w = 1; w < walls; w++) {
				int sig = Integer.parseInt(st.nextToken());
				if(sig>ini) high++;
				else if(sig<ini)low++;
				ini = sig;
			}
			sb.append("Case "+(c+1)+": "+high+" "+low+"\n");
		}
		System.out.print(new String(sb));
	}
}
