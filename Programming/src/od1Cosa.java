import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class od1Cosa {

	static TreeMap<String, Integer> nodos;
	static TreeMap<Integer, String> nodosString;
	static TreeMap<Integer, Integer> times;
	static ArrayList[] noseloquequierehacerpierre;
	static int N ;
	static boolean root[];
	static boolean mady[][] ;
	static int[] startIssue;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new FileReader("od1.in"));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int people = Integer.parseInt(st.nextToken());
		nodos = new TreeMap<String, Integer>();
		nodosString = new TreeMap<Integer, String>();
		times = new TreeMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			String nodo = st.nextToken();
			if(!nodos.containsKey(nodo)){
				int val = nodos.size();
				nodos.put(nodo, val);
				nodosString.put(val, nodo);
				times.put(val, Integer.parseInt(st.nextToken()));
			}
		}
		N = nodos.size();
		mady = new boolean[N][N];
		startIssue = new int[N];
		int e = Integer.parseInt(in.readLine());
		root = new boolean[N];
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(in.readLine());
			int a = nodos.get(st.nextToken());
			String s = st.nextToken();
			int b = nodos.get(s); 
			mady[a][b] = true;
			root[b] = true;
		}
		solve( );
		
		int mat[][] = new int[N][2];
		for (int i = 0; i < mat.length; i++) {
			mat[i][0] = i;
			mat[i][1] = startIssue[i];
		}
		
		Arrays.sort(mat, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		noseloquequierehacerpierre = new ArrayList[people];
		for (int i = 0; i < people; i++) 
			noseloquequierehacerpierre[i] = new ArrayList<Integer>();
		
		int[] peopleles = new int[people];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < mat.length; i++) {
			int min = Integer.MAX_VALUE;
			int index = -1;
			for (int j = 0; j < peopleles.length; j++) {
				int tiempoActual = Math.max(peopleles[j], mat[i][1])+times.get(mat[i][0]);
				if( tiempoActual < min ){
					min = tiempoActual;
					index = j;
				} 
			}
			peopleles[index]=Math.max(peopleles[index], mat[i][1])+times.get(mat[i][0]);
			noseloquequierehacerpierre[index].add(mat[i][0]);
			max = Math.max(peopleles[index], max);
		}
		System.out.println(String.format(Locale.US, "%.2f", ((max/60.)/60.)/7.)+ " días");
		for (int i = 0; i < noseloquequierehacerpierre.length; i++) {
			System.out.print("Persona "+(i+1)+" : ");
			for (int j = 0; j < noseloquequierehacerpierre[i].size(); j++) {
				System.out.print( nodosString.get(noseloquequierehacerpierre[i].get(j) )+" "+ ( Math.ceil((times.get((Integer)noseloquequierehacerpierre[i].get(j)) /60.)/60. ))+"\t");
			}
			System.out.println();
		}
		
		int i , j , k;
		i = j = k = 1;
		System.out.println(i + " " + j + " " + k );
	}
	
	static void solve( ){
		Queue<Integer> cola = new LinkedList<Integer>();
		Queue<Integer> time = new LinkedList<Integer>();
		for (int i = 0; i < root.length; i++) 
			if(!root[i]){
				cola.add(i);
				time.add(0);
			}
		while(!cola.isEmpty()){
			int act = cola.poll( );
			int nTime = time.poll( );
			startIssue[act] = Math.max(nTime, startIssue[act]);
			
			for (int i = 0; i < mady.length; i++) {
				if( mady[act][i] ){
					cola.add(i);
					time.add( nTime + times.get( act ) );
				}
			}
		}
	}
}
