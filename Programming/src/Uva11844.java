import java.io.*;
import java.util.*;

public class Uva11844 {
	static TreeMap<String, String> mu ; 
	static TreeMap<String, Integer> vi ;
	static TreeMap<String, Integer> cu ;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		for (String line; (line = in.readLine()) !=null; ) {
			StringTokenizer st = new StringTokenizer(line);
			int m = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if( m == 0 && i==0 && c == 0 && n == 0  ) break;

			boolean isCure = false;
			boolean isDeterministic = true;
			mu = new TreeMap<String, String>();
			vi = new TreeMap<String, Integer>();
			cu = new TreeMap<String, Integer>();
			
			for (int mutaciones = 0; mutaciones < m ; mutaciones++) {
				st = new StringTokenizer(in.readLine());
				String key = st.nextToken( );
				String val = st.nextToken( );
				if( mu.containsKey(key) ){
					if( !mu.get(key).equals(val) ){
						isDeterministic = false;
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
				if( cu.containsKey(key) ){
					cu.put(key, cu.get(key)+val);
				}else{
					cu.put(key, val);
				}
			}
			
//			System.out.println("Mutac: " + mu);
//			System.out.println("Virus: " + vi);
//			System.out.println("Curas: " + cu);

			
			int k = 0;
			if( isDeterministic ){
				for (int j = 0; j <= n && !isCure; j++) {
					if( iguales(vi, cu) ){
						isCure = true;
					}else{
//						System.out.println("Muta de: " + vi);
						mutar( );
//						System.out.println("Muta a : " + vi );
					}
					k = j;
				}
			}

			if( !isDeterministic ){
				sb.append("Protein mutations are not deterministic");
			}else{
				if(!isCure)
					sb.append("Nostalgia for Infinity is doomed");
				else
					sb.append("Cure found in "+k+" mutation(s)");
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}

	public static void mutar(  ) {
		TreeMap<String, Integer> tmp = new TreeMap<String, Integer>();
		for (String key : mu.keySet()) {
			if( vi.containsKey(key) ){
				String nKey  = mu.get(key);
				if(tmp.containsKey(nKey))
					tmp.put( nKey , tmp.get(nKey)+ vi.get(key));
				else
					tmp.put( nKey ,  vi.get(key));
				vi.remove(key);
			}
		}
		for (String key : vi.keySet()) {
			if(tmp.containsKey(key)){
				tmp.put(key, tmp.get(key)+vi.get(key));
			}else{
				tmp.put(key, vi.get(key));
			}
		}
		vi = tmp;
	}
	
	public static boolean iguales( TreeMap<String, Integer> vi , TreeMap<String, Integer> cu ){
		boolean iguales = true;
		for (String key : cu.keySet() ) {
			if( vi.containsKey(key) && vi.get(key).compareTo( cu.get(key) ) != 0 )
				iguales = false;
			else if( !vi.containsKey(key) )
				iguales = false;
		}
		return iguales;
	}
}
