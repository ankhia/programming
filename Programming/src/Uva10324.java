

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva10324 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		int casos = 1;
		for (String line; (line = in.readLine())!=null; casos++) {
			if(line.equals(""))break;
			int q = Integer.parseInt(in.readLine());
			sb.append("Case "+casos+":\n");
			for (int j = 0; j < q; j++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				boolean yes = true;
				for (int k = Math.min(a, b)+1; k <= Math.max(a, b) && yes; k++) {
					if(line.charAt(k)!=line.charAt(k-1))
						yes=false;
				}
				if(yes)
					sb.append("Yes\n");
				else sb.append("No\n");
			} 
		}
		System.out.print(new String(sb));
	}
}
