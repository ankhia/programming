import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Uva291 {

	static boolean[][] mady;
	static String []data = {"0 1","0 4","1 4","2 1","2 0","4 2","3 2", "4 3"};
	public static void main(String[] args) throws Throwable {
		mady = new boolean[5][5];
		for (int i = 0; i < data.length; i++) {
			StringTokenizer st = new StringTokenizer(data[i]);
			int f = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			mady[f][c] = true;
			mady[c][f] = true;
		}
		System.out.println(bfs());
	}

	static String bfs( ){
		StringBuilder sb = new StringBuilder( );
		boolean v[][] = new boolean[5][5];
		for (int i = 1; i < 5; i++) {
			if( mady[0][i] ) {
				v[0][i] = true;
				v[i][0] = true;
				Queue<Integer> nodos = new LinkedList<Integer>( );
				nodos.add( i );
				Queue<Integer> contador = new LinkedList<Integer>( );
				contador.add( 1 );
				int[  ]from = new int[ 5 ];
				Arrays.fill(from, -1);
				from[ i ] = 0;
				
				while( !nodos.isEmpty() ){
					int actual = nodos.poll( );
					int cont = contador.poll( );
					if( cont == 8 && actual == 0 ){
						int ini = 0;
						while( from[ini]!=0 ){
							sb.append(ini);
							ini = from[ini];
						}
						sb.append(ini);
						sb.append("\n");
					}else{
						
					}
						
				}
			}
			
		}
		
		return new String(sb);
	}

}
