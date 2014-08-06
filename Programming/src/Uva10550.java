import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva10550 {
	
	static StringBuilder sb ;
	static int pi,s,m,e;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder( );
		for (String line; (line = in.readLine())!=null ; ) {
			StringTokenizer st = new StringTokenizer(line);
			pi = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			if( pi == 0 && s == 0 && m == 0 && e == 0 ) break;
			solve( );
		}
		System.out.print(new String(sb));
	}
	
	private static void solve() {
		int sum = 1080;
		if( pi < s ){
			sum += pi*9;
			sum += (40-s)*9;
		}else
			sum+= (pi-s)*9;
//		System.out.println("--1  " + sum);
		if( s > m ){
			sum += (40-s)*9;
			sum += m*9;
		}else
			sum += (m-s)*9;
//		System.out.println("--2 "+sum);
		if( m < e ){
			sum += (40-e)*9;
			sum += m*9;
		}else
			sum += (m-e)*9;
//		System.out.println("--3 "+ sum);
		sb.append(sum).append("\n");
	}
	
}
