

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Acm4805 {

	static ArrayList<Integer>[ ] con ;
	static ArrayList<Integer>[ ] pes ;
	static long[ ] disRootANodo;
	static int[ ] niveles;
	static int[ ] papasDirectos;
	static int[ ] secciones;
	static int[ ] papasSecciones; 

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line; (line=in.readLine())!=null ; ) {
			int anthills = Integer.parseInt(line);
			if(anthills==0) break;

			con = new ArrayList[anthills];
			pes = new ArrayList[anthills];
			disRootANodo = new long[anthills];
			niveles = new int[anthills];
			papasDirectos = new int[anthills];
			secciones = new int[anthills];
			papasSecciones = new int[anthills];
			papasDirectos[0] = -1;

			for (int i = 0; i < anthills-1; i++) {
				ArrayList<Integer> lis ;
				ArrayList<Integer> p ;
				StringTokenizer st = new StringTokenizer(in.readLine());

				int iNodo = Integer.parseInt(st.nextToken());
				int iPeso = Integer.parseInt(st.nextToken());
				if( con[iNodo] == null )
					lis = new ArrayList<Integer>();
				else  	lis = con[iNodo];

				if( pes[iNodo]== null)
					p = new ArrayList<Integer>();
				else
					p = pes[iNodo];

				lis.add((i+1));
				p.add(iPeso);
				con[iNodo] = lis;
				papasDirectos[i+1] = iNodo;
				pes[iNodo] = p;
			}

			bfsRootANodo();

			int [] copy = niveles.clone();
			Arrays.sort(copy);
			int raizH = (int)( Math.ceil( Math.sqrt( (double)(copy[copy.length-1]) ) ) );
			for (int i = 0; i < niveles.length; i++) {
				secciones[i] = niveles[i]/raizH;
			}

			dfs(raizH);

			int query = Integer.parseInt(in.readLine());
			for (int i = 0; i < query; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int nodo1 = Integer.parseInt(st.nextToken());
				int nodo2 = Integer.parseInt(st.nextToken());
				sb.append(solve(nodo1, nodo2));
				if( i<query-1 )
					sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}


	public static long solve( int nodo1, int nodo2 ){
		return disRootANodo[nodo1] + disRootANodo[nodo2] - 2*disRootANodo[LCA(nodo1, nodo2)];
	}

	public static void bfsRootANodo( ){

		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Long> q2 = new LinkedList<Long>();
		Queue<Integer> nivel = new LinkedList<Integer>();
		q.add(0);
		q2.add(0l);
		nivel.add(0);
		while(!q.isEmpty()){
			int nodo = q.poll();
			long peso = q2.poll();
			int niv = nivel.poll();
			for (int i = 0; con[nodo] != null && i < con[nodo].size(); i++) {
				q.add(con[nodo].get(i));
				q2.add(pes[nodo].get(i)+peso);
				nivel.add(niv+1);
			}
			disRootANodo[nodo] = peso;
			niveles[nodo] = niv;
		}
	}

	public static void dfs( int raizH ){
		Stack<Integer> p = new Stack<Integer>();
		p.add(0);
		papasSecciones[0] = -1;
		while(!p.isEmpty()){
			int nodo = p.pop();
			int niv = niveles[nodo];
			if( niv % raizH != 0 )
				papasSecciones[nodo] = papasSecciones[papasDirectos[nodo]];
			else
				papasSecciones[nodo] = papasDirectos[nodo];
			for (int i = 0; con[nodo] != null && i < con[nodo].size(); i++) {
				p.add(con[nodo].get(i));
			}
		}
	}

	public static int LCA( int nodo1 , int nodo2 ){

		while( papasSecciones[nodo1] != papasSecciones[nodo2] ){
			if(niveles[nodo1]>niveles[nodo2])
				nodo1 = papasSecciones[nodo1];
			else
				nodo2 = papasSecciones[nodo2];
		}

		while( nodo1 != nodo2 ){
			if( niveles[nodo1] > niveles[nodo2] )
				nodo1 = papasDirectos[nodo1];
			else 
				nodo2 = papasDirectos[nodo2];
		}
		return nodo1;
	}
}
