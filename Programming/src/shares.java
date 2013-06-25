import java.io.*;
import java.util.*;

public class shares {

	static int[] price;
	static int[] forTheNextDay;
	static int[][] packs;
	static int [] peso;
	static int [] utilidad;
	static int n;
	static int p;
	static int m;
	static TreeMap<String, Long> mem;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line; (line=in.readLine())!=null; ) {
			m = Integer.parseInt(line); //capacidad de la mochila
			StringTokenizer st = new StringTokenizer(in.readLine()); 
			n = Integer.parseInt(st.nextToken()); // shares
			p = Integer.parseInt(st.nextToken()); //packs
			peso = new int [p];
			utilidad = new int [p];
			mem = new TreeMap<String, Long>();
			
			price = new int[n]; // precios de las acciones
			forTheNextDay = new int[n]; // precios del siguiente dia de cada accion
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				price[i] = Integer.parseInt(st.nextToken());
				forTheNextDay[i] = Integer.parseInt(st.nextToken());
			}
			packs = new int[n][p];
			for (int j = 0; j < p; j++) {
				st = new StringTokenizer(in.readLine());
				int cant = Integer.parseInt(st.nextToken());
				for (int i = 0; i < cant; i++) {
					int id = Integer.parseInt(st.nextToken());
					int q = Integer.parseInt(st.nextToken());
					packs[id-1][j] = q;
				}
			}
			pesoPack();
			utilidadPack();
			sb.append(mochila(m, p)+"\n");
		}
		System.out.print(new String(sb));
	}
	
	public static void pesoPack(  ){
		for (int j = 0; j < p; j++) {
			int suma = 0;
			for (int i = 0; i < n; i++) {
				suma+=packs[i][j]*price[i];
			}
			peso[j] = suma;	
		}
	}
	
	public static void utilidadPack( ){
		for (int j = 0; j < p; j++) {
			int suma = 0;
			for (int i = 0; i < n; i++) {
				suma+=packs[i][j]*(forTheNextDay[i]-price[i]);
			}
			utilidad[j]= suma;
		}
	}
	
	public static long mochila( int c, int j ){
		String id = c+"-"+(j-1);
		if(j == 0)
			return 0;
		if(mem.containsKey(id))return mem.get(id);
		if( j>0 && peso[ j-1 ] > c ){
			mem.put(id, mochila( c , j-1 ));
			return mem.get(id);
		}
		else{
			long value = Math.max(mochila(c, j-1) , mochila(c - peso[ j-1 ], j-1)+utilidad[j-1]);
			mem.put(id, value);
			return mem.get(id);
		}
	}
	
}
