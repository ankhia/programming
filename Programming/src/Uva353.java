import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Uva353 {

	static TreeSet<String> pal;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in) );
		StringBuilder sb = new StringBuilder( );
		for (String ln ; (ln = in.readLine())!=null; ) {
			StringTokenizer st = new StringTokenizer(ln.trim());
			String palabra = st.nextToken(); 
			String line = palabra.toLowerCase();
			pal = new TreeSet<String>();
			for (int i = 0; i < line.length(); i++) {
				for (int j = i+1; j <= line.length(); j++) {
					String n = line.substring(i, j);
					String rev = new String(new StringBuilder(n).reverse());
					if( n.equals(rev ))
						pal.add(n);
				}
			}
//			System.out.print(pal);
			sb.append("The string '"+palabra+"' contains "+pal.size()+" palidromes.").append("\n");
		}
		System.out.print(new String(sb));
	}
}
