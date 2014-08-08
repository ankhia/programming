

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva11727 {


	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int cas = Integer.parseInt( in.readLine() );
		for (int i = 1; i <= cas; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int[] totales = new int[3];
			totales[0] = Integer.parseInt(st.nextToken());
			totales[1] = Integer.parseInt(st.nextToken());
			totales[2] = Integer.parseInt(st.nextToken());

			Arrays.sort(totales);
			System.out.println("Case "+i+": "+totales[1]);
		}
	}
}
