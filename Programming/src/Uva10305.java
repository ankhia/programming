

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Uva10305 {

	static ArrayList[] lAdy;
	static boolean visitados[];
	static int aristasEntrantes[];
	static ArrayList<Integer> oT;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String linea; (linea = in.readLine())!=null; ) {
			StringTokenizer st = new StringTokenizer(linea);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n==0&&m==0)break;
			oT = new ArrayList<Integer>( );
			lAdy = new ArrayList[n];
			aristasEntrantes = new int[n];
			visitados = new boolean[n];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				ArrayList<Integer> arr ;
				if( lAdy[a-1] == null ){
					arr = new ArrayList<Integer>();
				}else{
					arr = lAdy[a-1];
				}
				arr.add(b-1);
				lAdy[a-1] = arr;
//				System.out.println();
				aristasEntrantes[b-1]+=1;
			}
			
//			System.out.println(Arrays.toString(aristasEntrantes));
			int copy[] = aristasEntrantes.clone();
//			System.out.println(Arrays.toString(aristasEntrantes));
			for (int i = 0; i < copy.length; i++) {
				if( copy[i]==0 )
					bfs( i );
			}
			
			for (int i = 0; i < oT.size(); i++) {
				sb.append((oT.get(i)+1)+" ");
//				sb.append(oT.get(i)+" ");
			}
//			System.out.println();
//			sb = new StringBuilder( sb.substring(0, sb.length()-2) );
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
	
	static void bfs( int n ){
		Queue<Integer> q = new LinkedList<Integer>( );
		q.add( n );
		
		while(!q.isEmpty()){
			int actual = q.poll();
			if( aristasEntrantes[actual] == 0 && !visitados[actual]){
				oT.add(actual);
				visitados[actual] = true;
				for (int i = 0; lAdy[actual]!=null &&  i < lAdy[actual].size(); i++) {
					int nHijo = (Integer) lAdy[actual].get(i);
					if( !visitados[nHijo] ){
						q.add(nHijo);
						aristasEntrantes[nHijo]--;
					}
				}
			}
		}
		
	}
}
