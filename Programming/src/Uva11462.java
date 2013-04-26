

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva11462 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line; (line = in.readLine())!= null ;) {
			int cant = Integer.parseInt(line);
			if( cant == 0 )break;
			int [] ages = new int[cant];
			StringTokenizer st = new StringTokenizer( in.readLine() );
			for (int i = 0; i < ages.length; i++) {
				ages[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(ages);
			for (int i = 0; i < ages.length; i++) {
				sb.append(ages[i]);
				if(i<ages.length-1)
					sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
