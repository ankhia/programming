import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CodeForces456A {
	static int[][] pq;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		pq = new int[n][2];
		boolean happyAlex = false;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			pq[i][0] = Integer.parseInt(st.nextToken());
			pq[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(pq, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0] ;
			}
		});
		
		TreeSet<Integer> tree = new TreeSet<Integer>();
		for (int i = 0 ; i< pq.length && !happyAlex; i++ ) {
			if(tree.ceiling( pq[i][1] ) != null )
				happyAlex = true;
			else
				tree.add(pq[i][1]);
		}
		System.out.println(!happyAlex?"Poor Alex":"Happy Alex");
	}
}
