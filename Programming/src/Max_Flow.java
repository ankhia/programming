import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Max_Flow {

	static int mAdy[][];
	static int sour ;
	static int dest ;
	static boolean v[];
	static int n;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String line; (line = in.readLine())!=null; ) {
			StringTokenizer st = new StringTokenizer(line);
			n = Integer.parseInt(st.nextToken());
			if(n==0)break;
			int e = Integer.parseInt(st.nextToken());
			sour = Integer.parseInt(st.nextToken());
			dest = Integer.parseInt(st.nextToken());
			mAdy = new int[n][n];
			v = new boolean[n]; 
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(in.readLine());
				int f = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				mAdy[f][c]=v;
			}
			//			System.out.println(Ford_Fulkerson());
			System.out.println( bfs( ) );
		}
	}

	public static int bfs(){ 
		int where;
		//	  queue Q
		Queue<Integer> Q = new LinkedList<Integer>();
		//	  push source to Q
		Q.add(sour);
		//	  mark source as visited
		boolean v [] = new boolean[n];
		v[sour] = true;
		//	  keep an array from with the semnification: from[x] is the 
		//	previous vertex visited in the shortest path from the source to x;
		//	initialize from with -1 (or any other sentinel value) 
		int[] from = new int[n];
		Arrays.fill(from, -1);
		//	while Q is not empty
		while( !Q.isEmpty() ){
			//	    where = pop from Q
			where = Q.poll();
			//	    for each vertex next adjacent to where
			for (int i = 0; i < mAdy.length; i++) {
				int next = mAdy[where][i];
				//			if next is not visited and capacity[where][next] > 0
				if( !v[next] && mAdy[where][i] > 0 ){
					//		        push next to Q
					Q.add(next);
					//		        mark next as visited
					v[next] = true;
					//		        from[next] = where
					from[next] = where;
					//		        if next = sink
					if( next == dest )
						break;
				}
				//	    end for
			}
			//	  end while
		}
		int prev;
		// we compute the path capacity
		where = dest; int path_cap = Integer.MAX_VALUE;
		//	  while from[where] > -1
		while( from[where] > -1){
			//	    prev = from[where] // the previous vertex
			prev = from[where];
			//	    path_cap = min(path_cap, capacity[prev][where])
			path_cap = Math.min(path_cap, mAdy[prev][where]);
			where = prev;
			//	  end while
		}
		// we update the residual network; if no path is found the while 
		//	loop will not be entered
		where = dest;
		//	  while from[where] > -1
		while(from[where] > -1){
			prev = from[where];
			mAdy[prev][where] -= path_cap;
			mAdy[where][prev] += path_cap;
			where = prev;
			//	  end while
		}
		// if no path is found, path_cap is infinity
		//	  if path_cap = infinity
		if(path_cap == Integer.MAX_VALUE)
			return 0;
		else return path_cap;
	}

	//	public static int Ford_Fulkerson(    ) {
	//		int[][] flu = new int[n][n];
	//		int[][] res = new int[n][n];
	//		for (int i = 0; i < n; i++) {
	//			for (int j = 0; j < n; j++) {
	//				res[i][j] = mAdy[i][j];
	//			}
	//		}
	//		ArrayList<Integer> camino = buscarCamino(res, sour, dest);
	//		while(camino != null){
	//			int min = Integer.MAX_VALUE;
	//			for(int i=0;i<camino.size()-1;++i)
	//				min = Math.min(min , res[camino.get(i)][camino.get(i+1)]);
	//			for(int i=0;i<camino.size()-1;i++){
	//				int x = camino.get(i);
	//				int y = camino.get(i+1);
	//				flu[x][y] += min;
	//				flu[y][x] = -flu[x][y];
	//				res[x][y] -= min;
	//				res[y][x] += min;
	//			}
	//			camino = buscarCamino(res, sour, dest);
	//		}
	//		int flujoMax = 0; 
	//		for (int i = 0; i < flu.length; i++) {
	//			flujoMax+=flu[i][dest];
	//		}
	//		return flujoMax;
	//	}
	//	
	//	public static ArrayList<Integer> buscarCamino( int[][] res , int s , int t ){
	//		Queue<Integer> q = new LinkedList<Integer>();
	//		Queue<ArrayList<Integer>> h = new LinkedList<ArrayList<Integer>>();
	//		q.add(s);
	//		boolean v[] = new boolean[res.length];
	//		ArrayList<Integer> hijos = new ArrayList<Integer>();
	//		hijos.add(s);
	//		h.add(hijos);
	//		while(!q.isEmpty()){
	//			int a = q.poll();
	//			ArrayList<Integer> hijitos = h.poll();
	//			if( a == t ){
	//				return hijitos;
	//			}else {
	//				for (int i = 0; i < res.length; i++) {
	//					if( res[a][i] > 0 &&!v[i]){
	//						v[i]=true;
	//						q.add(i);
	//						ArrayList<Integer> masHijitos = new ArrayList<Integer>();
	//						for (Integer integer : hijitos) {
	//							masHijitos.add( integer );	
	//						}
	//						masHijitos.add(i);
	//						h.add( masHijitos );
	//					}
	//				}
	//			}
	//		}
	//		return null;
	//	}
}
