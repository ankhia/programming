import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Uva414 {
	
	static String[] lines;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		for (String ln ; (ln = in.readLine())!= null; ) {
			int n = Integer.parseInt(ln.trim());
			if(n==0)break;
			lines = new String[n];
			int maxLength = Integer.MIN_VALUE; 
			for (int i = 0; i < n; i++) {
				String line = in.readLine( ).trim( );
				for (int j = 0; j < line.length(); j++)
					if( !Character.isWhitespace(line.charAt(j) ))
						lines[i] += line.charAt(j)+"";
				if( lines[i].length() > maxLength ) maxLength = lines[i].length( );	
			}
			int cant = 0;
			for (int i = 0; i < lines.length; i++) {
				cant += maxLength - lines[i].length( ); 
			}
			sb.append(cant).append("\n");
		}
		System.out.print(new String(sb));
	}
}
