import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class od1Cosa {

	static TreeMap<String, Integer> nodos;
	static TreeMap<String, Integer> times;
	static int N ;
	static boolean root[];
	static boolean mady[][] ;
	static int[] startIssue;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new FileReader("od1.in"));
		int n = Integer.parseInt(in.readLine());
		System.out.println(n);
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String nodo = st.nextToken();
			if(!nodos.containsKey(nodo)){
				nodos.put(nodo, nodos.size());
				times.put(nodo, Integer.parseInt(st.nextToken()));
			}
		}
		N = nodos.size();
		mady = new boolean[N][N];
		startIssue = new int[N];
		int e = Integer.parseInt(in.readLine());
		root = new boolean[N];
		for (int i = 0; i < e; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = nodos.get(st.nextToken());
			int b = nodos.get(st.nextToken()); 
			mady[a][b] = true;
			root[b] = true;
		}
		solve( );
	}
	
	static int solve( ){
		Queue<Integer> cola = new LinkedList<Integer>();
		for (int i = 0; i < root.length; i++) 
			if(!root[i])
				cola.add(i);
		
		while(!cola.isEmpty()){
			int act = cola.poll( );
			
		}
		return 0;
	}
	
	static void bfs(  ){
		
	}
	
	
}
