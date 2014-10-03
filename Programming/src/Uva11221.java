import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Uva11221 {

	static String line;
	
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int c = 1; c <= cases; c++) {
			sb.append("Case #").append(c).append(":\n");
			String ln = in.readLine();
			line = cleanString( ln );
			double N = Math.sqrt( line.length() ) ;
			if( N % 1. == 0. ){
				if (isValid((int)N)) {
					sb.append(String.format("%.0f", N)).append("\n");
				}else{
					sb.append("No magic :(\n");
				}
			}else
				sb.append("No magic :(\n");
		}
		System.out.print(new String(sb));
	}
	
	public static String rec2( int N , String s ){
		StringBuilder sb = new StringBuilder( );
		for (int i = 0; i < N; i++) {
			for (int j = i; j < s.length(); j+=N) {
				sb.append(s.charAt(j));
			}
		}
		return new String(sb);
	}
	
	public static boolean isValid( int N ){
		StringBuilder sb = new StringBuilder( line ) ;
		String reverse = new String( sb.reverse( ) );
		String llamealmetodo = rec2(N, line);
		String llamedenuevo = rec2(N, reverse);
		if( line.equals( reverse ) && line.equals(llamealmetodo) && line.equals(llamedenuevo))
				return true;
		return false;
	}
	
	public static String cleanString( String s ){
		StringBuilder sb = new StringBuilder( );
		for (int i = 0; i < s.length(); i++){
			char actual = s.charAt(i);
			if( Character.isLetter(actual))
				sb.append(actual);
		}
		return new String(sb);
	}
	
}
