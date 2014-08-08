import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva10340 {
	
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		for (String line; (  line = in.readLine() )!=null; ) {
			StringTokenizer st = new StringTokenizer(line);
			String s = st.nextToken();
			String t = st.nextToken();
			boolean completo = true;
			boolean esta[] = new boolean[s.length()]; 
			boolean termine = false;
			for (int i = 0; i < s.length( ) && !termine; ) {
				for (int j = 0; j < t.length( ) && !termine; j++) {
					if( t.charAt( j ) == s.charAt( i ) ){
						esta[ i ] = true;
						i++;
					}
					if( j == t.length()-1 || i == s.length())
						termine=true;
				}
			}
			
			for (int i = 0; i < esta.length && completo; i++) {
				if(!esta[i]){
					sb.append("No\n");
					completo= false;
				}
			}
			if( completo ){
				sb.append("Yes\n");
			}
		}
		System.out.print(new String( sb ));
	}

}
