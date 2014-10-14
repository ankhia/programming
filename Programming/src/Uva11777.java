import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Uva11777 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in ));
		int t = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder( );
		for (int casos = 0; casos < t; casos++) {
			sb.append("Case ").append(casos+1).append(": ");
			StringTokenizer st = new StringTokenizer(in.readLine( ) );
			int a = 0;
			for (int i = 0; i < 4; i++) {
				a+= Integer.parseInt(st.nextToken());
			}
			int b[] = new int[3];
			for (int i = 0; i < b.length; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(b);
			int av = (b[b.length-1]+b[b.length-2])/2;
			a+=av;
			if( a >= 90 ) sb.append("A");
			else if( a >= 80 ) sb.append("B");
			else if( a >= 70 ) sb.append("C");
			else if( a >= 60 ) sb.append("D");
			else sb.append("F");
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
