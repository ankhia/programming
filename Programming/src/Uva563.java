import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import static java.lang.Integer.*;


public class Uva563 {

	static int [][]c;
	static int mAdy[][];
	static int s;
	static int t;
	static int n ;
	static HashMap<Integer, ArrayList<Integer>> code;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line; (line=in.readLine())!= null;) {
			StringTokenizer st = new StringTokenizer(line);
			int m = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if(m==0&&w==0) break;			
			n = m + (m-2);
			c = new int[n][n];
			t = m-1;
			mAdy = new int[n][n];
			for (int i = 0; i < m-2; i++) {
				st = new StringTokenizer(in.readLine());
				int k = Integer.parseInt(st.nextToken())-1;
				int v = Integer.parseInt(st.nextToken());
				c[ k ][ k + (m-1)] = v;
//				c[ k + (m-1) ][ k ] = v;
				
//								System.out.println( (k) +" "+ (k+(m-1))+" " + v);
			}

			for (int i = 0; i < w; i++) {
				st = new StringTokenizer(in.readLine());
				int k = Integer.parseInt(st.nextToken())-1;
				int l = Integer.parseInt(st.nextToken())-1;
				int v = Integer.parseInt(st.nextToken());
//								System.out.println("--------> " + k +" "+ l+" " + v);
				if( k != 0 && l != m-1 ){
					c[ k+(m-1) ][ l ] = v;
//										System.out.println( (k+(m-1)) +" "+ l+" " + v);
					c[ l+(m-1) ][ k ] = v;
//										System.out.println((l+(m-1)) +" "+ k+" " + v);
				}else if( k != 0 ){
					c[ k +(m-1) ][ l ] = v;
//										System.out.println((k+(m-1)) +" "+ l+" " + v);
//					c[ l ][  k +(m-1) ] = v;
//										System.out.println( l +" "+ (k+(m-1))+" " + v);
				}else if( l != m-1 ){
					c[ k ][ l ] = v;
//										System.out.println(k+" "+(l)+" "+v);
//					c[ l ][ k ] = v;
					//					System.out.println((l)+" "+k+" "+v);
				}else{
					c[ k ][ l ] = v;
				}
			}
//			imp(c);
		
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					if( c[i][j] != 0 ){
////						mAdy[i][j]=1;
////						mAdy[j][i]=1;
//					}
//				}
//			}
//			imp(mAdy);
			
			
			sb.append(pushRelabel(c, s, t)+"\n");
		}
		System.out.print(new String(sb));
	}

	
	static void push(int [][]C, int [][]F, int []excess, int u, int v) {
		int send = Math.min(excess[u], C[u][v] - F[u][v]);
		F[u][v] += send;
		F[v][u] -= send;
		excess[u] -= send;
		excess[v] += send;
	}

	static void relabel(int [][]C, int [][]F, int []height, int u) {
		int v;
		int min_height = Integer.MAX_VALUE;
		for (v = 0; v < n; v++) {
			if (C[u][v] - F[u][v] > 0) {
				min_height = Math.min(min_height, height[v]);
				height[u] = min_height + 1;
			}
		}
	}

	static void discharge(int [][]C, int [][]F, int []excess, int []height, int []seen, int u) {
		while (excess[u] > 0) {
			if (seen[u] < n) {
				int v = seen[u];
				if ((C[u][v] - F[u][v] > 0) && (height[u] > height[v])){
					push(C, F, excess, u, v);
				}
				else
					seen[u] += 1;
			} else {
				relabel(C, F, height, u);
				seen[u] = 0;
			}
		}
	}

	static void moveToFront(int i, int []A) {
		int temp = A[i];
		int n;
		for (n = i; n > 0; n--){
			A[n] = A[n-1];
		}
		A[0] = temp;
	}

	static int pushRelabel(int [][]C, int source, int sink) {
		int[][] F = new int[n][n];
		int []excess = new int[n];
		int []height = new int[n];
		int []list  = new int[n];
		int []seen  = new int[n];
		int i, p;

		for (i = 0, p = 0; i < n; i++){
			if((i != source) && (i != sink)) {
				list[p] = i;
				p++;
			}
		}

		height[source] = n;
		excess[source] = Integer.MAX_VALUE;
		for (i = 0; i < n; i++)
			push(C, F, excess, source, i);

		p = 0;
		while (p < n - 2) {
			int u = list[p];
			int old_height = height[u];
			discharge(C, F, excess, height, seen, u);
			if (height[u] > old_height) {
				moveToFront(p,list);
				p=0;
			}
			else
				p += 1;
		}
		int maxflow = 0;
		for (i = 0; i < n; i++)
			maxflow += F[source][i];

		return maxflow;
	}

	static void imp( int[][] mady){
		System.out.println("**********");
		for (int i = 0; i < mady.length; i++) {
			System.out.println(Arrays.toString(mady[i]));
		}
		System.out.println();
	}
}
