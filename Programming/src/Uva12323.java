import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva12323 {

	public static int m[ ][ ];
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String line; (line = in.readLine()) != null; ) {
			StringTokenizer st = new StringTokenizer(line);
			int nObjects = Integer.parseInt( st.nextToken( ) );
			int range = Integer.parseInt( st.nextToken( ) );
			if( nObjects == 0 && range == 0 ) break;
			m = new int[range][720];
			
				
		}
	}

}
