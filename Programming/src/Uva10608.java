import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Uva10608 {

	static TreeSet[]lady;
	static boolean visitados[];
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(in.readLine().trim());
		for (int c = 0; c < testCases; c++) {
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			lady= new TreeSet[N];
			for (int i = 0; i < lady.length; i++) 
				lady[i] = new TreeSet<Integer>();
			visitados = new boolean[N];
			for (int k = 0; k < M; k++) {
				st = new StringTokenizer(in.readLine().trim());
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken())-1;
				lady[from].add(to);
				lady[to].add(from);
			}
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < lady.length; i++) {
				max = Math.max(bfs(i), max);
			}
			System.out.println(max);
		}
	}

	public static int bfs( int i ){
		Queue<Integer> cola = new LinkedList<Integer>();
		int friends = 0;
		cola.add(i);
		visitados[i] = true;
		while( !cola.isEmpty() ){
			int actual = cola.poll();
			friends++;;
			for ( Integer j : (TreeSet<Integer>)lady[actual] ) {
				int hijo = j;
				if( !visitados[hijo] ){
					cola.add(hijo);
					visitados[hijo] = true;
				}
			}
		}
		return friends;
	}
}
