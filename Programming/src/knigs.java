

import java.io.*;
import java.util.*;

/**
 * @author Angie Milena Vega Leon
 * @veredict Accepted 
 * @problemId 
 * @problemName  knigs
 * @judge Boca
 * @category ls
 * @level Easy
 * @date 22/07/2012
 **/
public class knigs {

	static int[] c;
	
	public static void main(String[] args) throws Throwable {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (StringTokenizer st; (st=new StringTokenizer(in.readLine())) != null; ) {
			int k = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if( k == 0 && n == 0 ) break;
			
			PriorityQueue<int[]> fuerza = new PriorityQueue<int[]>(1, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return o2[1]-o1[1];
				}
			});
			PriorityQueue<int[]> cand = new PriorityQueue<int[]>(1, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return o1[0]-o2[0];
				}
			});
			
			int fuerzaObj = -1;
			for (int i = 0; i < (n+k-1); i++) {
				st = new StringTokenizer(in.readLine());
				c = new int[2];
				c[0] = Integer.parseInt(st.nextToken());
				c[1] = Integer.parseInt(st.nextToken());
				if(c[0]==2011)
					fuerza.add(c);
				else
					cand.add(c);
				if(i == 0)
					fuerzaObj = c[1];
			}
//			System.out.println(fuerza.size());
//			while( !fuerza.isEmpty() ){
//				int f[] = fuerza.poll();
//				System.out.println(Arrays.toString(f));
//			}
//			System.out.println();
//			while( !cand.isEmpty() ){
//				int f[] = cand.poll();
//				System.out.println(Arrays.toString(f));
//			}
			
//			System.out.println(fuerza.size());
//			System.out.println(cand.size() == (n+k-1)-fuerza.size());
//			int x = 12583095;
//			System.out.println((fuerzaObj == x));
			
			int anioGano = -1; 
			int anioActual = -1;
			while( fuerza.size() >= k && anioGano==-1 ){
				
				int f[] =  fuerza.poll();
				int c[] = cand.poll();

				if(f[1]==fuerzaObj){
					anioGano = (f[0]>=anioActual)?f[0]:anioActual;
				}
				if( c != null){
					fuerza.add(c);
					anioActual = c[0];
				}
			}
			
			if(anioGano != -1){
				sb.append(anioGano);
			}else
				sb.append("unknown");
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}

}
