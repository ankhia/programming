

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Uva612 {

	static Set<Coso> cadenas;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt( in.readLine( ) );
		for (int it = 0; it < t; it++) {
			if(it>0)sb.append("\n");
			in.readLine( );
			StringTokenizer st = new StringTokenizer(in.readLine());
			Integer.parseInt(st.nextToken());
			int numStrings = Integer.parseInt(st.nextToken());
			
			cadenas = new TreeSet<Coso>();
			for (int i = 0; i < numStrings; i++) {
				String cadena = in.readLine( );
				int p = i;
				cadenas.add(new Coso(cadena, p));
			}
			
			for (Coso c : cadenas) {
				sb.append(c.cadena+"\n");
			}
		}
		System.out.println(new String(sb));
	}

	static class Coso implements Comparable<Coso>{
		String cadena;
		int num;
		int p;
		
		public Coso( String cad , int po ){
			this.cadena = cad;
			this.p = po;
			int total = 0;
			for (int i = 0; i < cadena.length(); i++) {
				for (int j = (i+1); j < cadena.length(); j++) {
					if( cadena.charAt(i) > cadena.charAt(j) )
						total++;
				}
			}
			this.num=total;
		}
		
		
		public int compareTo(Coso o) {
			return (this.num<o.num)?-1:(this.num>o.num)?1:(this.p-o.p);
		}
	}
}

