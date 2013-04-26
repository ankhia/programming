

import java.io.*;
import java.util.*;

/**
 * @author Angie Milena Vega Leon
 * @veredict Accepted 
 * @problemId 
 * @problemName  Car Trouble
 * @judge Boca
 * @category BFS 
 * @level Easy
 * @date 30/07/2012
 **/
public class car {
	static boolean m[][];
	static boolean v[];
	static int[] orden;
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder sbU ;
		StringBuilder sbT ;
		m = new boolean[1001][1001];
		v = new boolean[1001];
		for (String linea; (linea = in.readLine())!=null;) {
			int cantCalles = Integer.parseInt(linea);
			if(cantCalles == 0) break;
			sbU = new StringBuilder( );
			sbT = new StringBuilder( );
			orden = new int[cantCalles];

			for (int i = 0; i < cantCalles; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int ide = Integer.parseInt(st.nextToken());
				orden[i]=ide;
				int reach = Integer.parseInt(st.nextToken());
				for (int j = 0; j < reach; j++) {
					int reached = Integer.parseInt(st.nextToken());
					m[ide][reached] = true;
				}
			}

			TreeSet<Integer> trapped = trapped( );
			Arrays.fill(v, false);
			TreeSet<Integer> unreachable = unreachable( );

			if(trapped.size() == cantCalles && unreachable.size()==cantCalles){
				sb.append("NO PROBLEMS\n");
			}else{
				for (int i = 0; i < orden.length; i++) {
					if(!unreachable.contains(orden[i])){
						sbU.append("UNREACHABLE "+orden[i]+"\n");
					}
					if(!trapped.contains(orden[i])){
						sbT.append("TRAPPED "+orden[i]+"\n");
					}
				}
				sb.append(sbT);
				sb.append(sbU);
			}
			
			for (int i = 0; i < m.length; i++) 
				Arrays.fill(m[i], false);
			Arrays.fill(v, false);

		}
		System.out.print(new String(sb));
	}

	private static TreeSet<Integer> unreachable() {
		TreeSet<Integer> reachable = new TreeSet<Integer>();
		Queue<Integer> cola = new LinkedList<Integer>();
		reachable.add(0);
		cola.add(0);
		v[0] = true;
		while(!cola.isEmpty()){
			int a = cola.poll();
			for (int i = 0; i < m[a].length; i++) {
//				System.out.println( " Viendo  m["+a+"]["+i+"] = "+m[a][i] );
				if(m[a][i] && !v[i]) {
					cola.add(i);
					v[i] = true;
					reachable.add(i);
				}
			}
		}
		return reachable;
	}

	private static TreeSet<Integer> trapped() {
		TreeSet<Integer> reachable = new TreeSet<Integer>();
		Queue<Integer> cola = new LinkedList<Integer>();
		reachable.add(0);
		cola.add(0);
		v[0] = true;
		while(!cola.isEmpty()){
			int a = cola.poll();
			for (int i = 0; i < m.length; i++) {
//				System.out.println( " Viendo  m["+i+"]["+a+"] = "+m[i][a] );
				if(m[i][a] && !v[i]) {
					cola.add(i);
					v[i] = true;
					reachable.add(i);
				}
			}
		}
		return reachable;
	}
}
