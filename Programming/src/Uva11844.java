import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Uva11844 {
	static TreeMap<String, String> mu ; 
	static TreeMap<String, Integer> vi ;
	static TreeMap<String, Integer> cu ;
	static ArrayList<String> compartidas;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String line; (line = in.readLine()) !=null; ) {
			StringTokenizer st = new StringTokenizer(line);
			int m = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			boolean hayCura = true;
			if( m == 0 && i==0 && c == 0 && n == 0  ) break;

			mu = new TreeMap<String, String>();
			vi = new TreeMap<String, Integer>();
			cu = new TreeMap<String, Integer>();
			compartidas = new ArrayList<String>();
			for (int mutaciones = 0; mutaciones < m && hayCura; mutaciones++) {
				st = new StringTokenizer(in.readLine());
				String key = st.nextToken( );
				String val = st.nextToken( );
				if( mu.containsKey(key) ){
					if( !mu.get(key).equals(val) ){
						hayCura = false;
					}
				}else{
					mu.put(key, val);
				}
			}

			for (int virus = 0; virus < i; virus++) {
				st = new StringTokenizer(in.readLine());
				String key = st.nextToken( );
				int val = Integer.parseInt(st.nextToken( ));
				if( vi.containsKey(key) ){
					vi.put(key, vi.get(key)+val);
				}else{
					vi.put(key, val);
				}
			}

			for (int cura = 0; cura < c; cura++) {
				st = new StringTokenizer(in.readLine());
				String key = st.nextToken( );
				int val = Integer.parseInt(st.nextToken( ));
				if(vi.containsKey(key)){
					//TODO restar al virus y si llega a 0 borrar de virus
					compartidas.add(key);
				}
				if( cu.containsKey(key) ){
					cu.put(key, cu.get(key)+val);
				}else{
					cu.put(key, val);
				}
			}

			for (int j = 0; j < n; j++) {
				
				String key = compartidas.get(i);
				if( cu.get(key)-vi.get(key) < 0  ){
					
				}
			}



			System.out.println( vi );
			System.out.println( cu );

		}
	}
}
