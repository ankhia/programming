import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;


public class Uva383 {

	static String ware[];
	static TreeMap<String, Integer> tree;
	static int mAdy[][];
	public static void main(String[] args) throws Throwable {
		Scanner in = new Scanner( new InputStreamReader( System.in ) );
		int tc = Integer.parseInt(in.nextLine());
		for (int t = 0; t < tc; t++) {
			int m = in.nextInt();
			int n = in.nextInt();
			int p = in.nextInt();
			ware = new String[m];
			tree = new TreeMap<String, Integer>();
			for (int i = 0; i < m; i++) {
				ware[i] = in.next();
				tree.put(ware[i], i);
			}
			System.out.println(Arrays.toString(ware));
			mAdy = new int[m][m];
			
			for (int i = 0; i < n; i++) {
				String s = in.next();
				String d = in.next();
				for (int j = 0; j < m; j++) {
					if(i==j) mAdy[i][j]=-1;
					else{
						mAdy[tree.get(s)][tree.get(d)] = 1;
					}
				}
			}
			
			for (int i = 0; i < m; i++) {
				System.out.println(Arrays.toString(mAdy[i]));
			}
			
			for (int i = 0; i < p; i++) {
				int shipment = in.nextInt();
				int s = tree.get(in.next());
				int d = tree.get(in.next());
				System.out.println(bfs( s,d,shipment ));
			}
			
		}
	}
	
	
	public static int bfs( int s, int d, int shipment ){
		
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> costo = new LinkedList<Integer>();
		q.add(s);
		costo.add(0);
		while (!q.isEmpty()) {
			int a = q.poll();
			int c = costo.poll();
			if( a == d ){
				return shipment * c * 100;
			}else{
				for (int i = 0; i < mAdy.length; i++) {
					if( mAdy[a][i] == 1 )
						q.add(i);
						costo.add(c+1);
				}
			}
		}
		return -1;
		
	}

}
