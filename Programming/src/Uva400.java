import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;


public class Uva400 {

	static char matriz[][];
	static TreeMap<String, Integer> palabras;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String ln ; (ln = in.readLine())!= null;) {
			palabras = new TreeMap<String, Integer>();
			int N = Integer.parseInt(ln.trim());
			int maxTam = 0;
			for (int i = 0; i < 60; i++) 
				sb.append("-");
			sb.append("\n");
			int cantPal = 0;
			for (int i = 0; i < N; i++) {
				String palabra = in.readLine().trim();
				cantPal++;
				if( palabras.containsKey(palabra) ){
					palabras.put(palabra, palabras.get(palabra)+1);
				}else
					palabras.put(palabra, 1);
				maxTam = Math.max(palabra.length(), maxTam);
			}
			int c = (int) (Math.floor( (60.-maxTam) / (maxTam+2) ) + 1);
			int r = (int) Math.ceil( (double) cantPal / (double) c);
			matriz = new char[r][60];
			int y = 0;
			int w = 0;
			ArrayList<String> cosa = palabras(  );
			for (String p : cosa) {
				for (int j = y, s = 0; j < p.length()+y ; j++, s++) {
						matriz[w][j] = p.charAt(s);
				}
				w++;
				w = (w%r);
				if( w == 0 ) 
					y += maxTam+2;
			}
			
			for (int i = 0; i < matriz.length; i++) {
				int h = 0;
				for (int j = 0; j < c; j++){
					int temp = h;
					for (int j2 = h; j2 < (j < c-1?temp+maxTam+2:temp+maxTam ); j2++, h++) {
						sb.append(matriz[i][j2]);
					}
				}
				sb.append("\n");
			}
		}
		System.out.print(new String(sb));
	}
	
	public static ArrayList<String> palabras(  ){
		ArrayList<String> lista = new ArrayList<String>();
		for( String k : palabras.keySet() ){
			for (int i = 0; i < palabras.get(k); i++) {
				lista.add(k);
			}
		}
		return lista;
	}
}
