

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=945
 * @veredict Accepted
 * @problemId 10004
 * @problemName  Bicoloring
 * @judge http://uva.onlinejudge.org/
 * @category Grafos :S :D 
 * @level Easy
 * @date 08/08/2012
 **/

public class Uva10004 {

	static boolean mAdy[][];
	static int color[];
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		while( n != 0 ){
			mAdy = new boolean[n][n];
			color = new int[n];
			Arrays.fill(color, -1);
			int l =  Integer.parseInt(in.readLine());
			for (int i = 0; i < l; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				mAdy[a][b] = true;
				mAdy[b][a] = true;
			}
			
//			for (int i = 0; i < mAdy.length; i++) {
//				System.out.println(Arrays.toString(mAdy[i]));
//			}
			
			System.out.println((BFS())?"BICOLORABLE.":"NOT BICOLORABLE.");
			n = Integer.parseInt(in.readLine());
		}
	}
	
	public static boolean BFS( ){
		boolean bicoloreable = true;
		Queue<Integer> cola = new LinkedList<Integer>();
		cola.add(0);
		color[0] = 1;
		while (!cola.isEmpty()) {
			
			int a = cola.poll();
			for (int i = 0; i < mAdy.length; i++) {
				if(color[i]==-1 && mAdy[a][i]){
					cola.add(i);
					if(color[a]==1)
						color[i]=2;
					else
						color[i]=1;
				}else if( color[i] == color[a] && mAdy[a][i]){
					bicoloreable = false;
					break;
				}
			}
		}
		return bicoloreable;
	}
	
	public static void DFS( ){
		
	}
}
