

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Uva10226 {

	static TreeMap<String, Integer> h = new TreeMap<String, Integer>();
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt( in.readLine( ) );
		in.readLine();
		for (int i = 0; i < t; i++) {
			int total = 0;
			for( String line; (line = in.readLine())!=null && !line.equals("");  ) {
				if( h.get(line) == null )
					h.put(line, 1);
				else{
					h.put(line, h.get(line)+1);
				}
				total ++;
			}
			for( String x : h.keySet() ) {
				System.out.printf(x+" %.4f\n", ( total > 0 ? ( (double)(h.get(x)*100 ) / total  ): 0.  ) );
			}
		}
	}
}
