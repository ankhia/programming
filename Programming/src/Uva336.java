

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Uva336 {
	
	static HashMap<Integer, Integer> codigo;
	static int[][] m ;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		m = new int[30][30];
		StringBuilder sb = new StringBuilder();
		int numConnections = in.nextInt();
		int casoActual = 1;
		while( numConnections != 0 ){
			for (int i = 0; i < m.length; i++) {
				Arrays.fill(m[i], Integer.MAX_VALUE);
				m[i][i]=0;
			}
			codigo = new HashMap<Integer, Integer>();
			int contCod=0;
			for (int i = 0; i < numConnections; i++) {
				int nodoUno = in.nextInt( );
				int nodoDos = in.nextInt( );
				
				if( codigo.get(nodoUno) == null)
					codigo.put(nodoUno, contCod++);
				if( codigo.get(nodoDos) == null)
					codigo.put(nodoDos, contCod++);
				if(nodoUno!=nodoDos){
					m[codigo.get(nodoUno)][codigo.get(nodoDos)] = 1;
					m[codigo.get(nodoDos)][codigo.get(nodoUno)] = 1;
				}
				
 			}
			
			floyd();

			int nod = in.nextInt();
			int ttl = in.nextInt();
			while( nod!=0||ttl!=0 ){
				int cont = 0;
				int i;
				if(codigo.get(nod)!=null)
					i = codigo.get(nod);
				else {
					i = contCod;
					codigo.put(nod, contCod++);
				}
				
				for (int j = 0 ; j < codigo.size(); j++) {
					if(m[i][j]>ttl)
						cont++;
				}
				sb.append("Case "+casoActual+++": "+cont+" nodes not reachable from node "+nod+" with TTL = "+ttl+".\n");
				nod=in.nextInt();
				ttl=in.nextInt();
			}
			numConnections = in.nextInt();
		//	System.out.println("++++++++++" +numConnections);
		}
		System.out.print(new String(sb));
		
	}
	
	static void floyd (  ){
		for (int k = 0; k < codigo.size(); k++) {
			for (int i = 0; i < codigo.size(); i++) {
				for (int j = 0; j < codigo.size(); j++) {
					if(m[i][k]!=Integer.MAX_VALUE&&m[k][j]!=Integer.MAX_VALUE)
					m[i][j]=Math.min(m[i][j], m[i][k]+m[k][j]);
				}
			}
		}
	}
	
}
