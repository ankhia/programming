

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Angie Milena Vega Leon
 * @veredict Accepted 
 * @problemId 
 * @problemName  Elevator Trouble
 * @judge Boca
 * @category BFS
 * @level Easy
 * @date 25/07/2012
 **/

public class elevator {

	public static void main(String[] args) throws Throwable{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int f, s , g , u , d;
		StringBuilder sb = new StringBuilder();
		for (StringTokenizer st; (st=new StringTokenizer(in.readLine()))!=null; ) {
			f = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			u = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			
			if( f==0 && s==0 && g == 0 && u == 0 && d == 0 ) break;
			
//			System.out.println(f+" "+s+" "+g+" "+u+" "+d);
			boolean visitados[] = new boolean[f+1];
			Queue<Integer> colaNiveles = new LinkedList<Integer>();
			Queue<Integer> colaPisos = new LinkedList<Integer>();
			colaPisos.add(s);
			colaNiveles.add(0);
			visitados[s] = true;
			int nivel = -1;
			while( !colaPisos.isEmpty() && nivel == -1){
				
				int n = colaNiveles.poll();
				int p = colaPisos.poll();
				if(p == g)
					nivel = n;
				
				if( (p+u) <= f && !visitados[p+u] ){
					colaPisos.add(p+u);
					colaNiveles.add(n+1);
					visitados[p+u] = true;
				}
				if( (p-d) > 0 && !visitados[p-d]){
					colaPisos.add(p-d);
					colaNiveles.add(n+1);
					visitados[p-d] = true;
				}
				
			}
			
			if(nivel == -1)
				sb.append("use the stairs\n");
			else
				sb.append(nivel+"\n");
		}
		System.out.print(new String(sb));
	}
}
