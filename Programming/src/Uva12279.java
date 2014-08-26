import java.io.*;
import java.util.StringTokenizer;


public class Uva12279 {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int caso = 1;
		for (String line; (line = in.readLine()) != null; caso++) {
			int n = Integer.parseInt(line.trim());
			if(n==0)break;
			StringTokenizer st = new StringTokenizer(in.readLine());
			int book = 0;
			int treats = 0;
			for (int k = 0; k < n; k++) {
				if( Integer.parseInt(st.nextToken()) == 0 )
					treats++;
				else book++;
			}
			sb.append("Case ").append(caso).append(": ").append(book-treats).append("\n");
		}
		System.out.print(new String(sb));
	}

}
