import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;


public class Uva11984 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		int casos = Integer.parseInt(in.readLine().trim());
		for (int caso = 0; caso < casos; caso++) {
			sb.append("Case " +(caso+1)+": ");
			StringTokenizer st = new StringTokenizer(in.readLine());
			double c = Double.parseDouble(st.nextToken());
			double f = Double.parseDouble(st.nextToken());
			sb.append(String.format(Locale.US, "%.2f", fToC(cToF(c)+f))).append("\n")	;
		}
		System.out.print(new String(sb));
	}
	
	static double cToF( double c ){
		return (( 9 * c ) / 5 ) + 32;
	}
	static double fToC( double f ){
		return (5 * (f - 32) )/9;
	}
}
