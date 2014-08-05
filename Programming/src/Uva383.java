import java.io.*;
import java.util.*;

public class Uva383 {

	static boolean ware[];
	static TreeMap<String, Integer> tree;
	static int mAdy[][];
	static boolean[] v; 
	public static void main(String[] args) throws Throwable {
		Scanner in = new Scanner( new InputStreamReader( System.in ) );
		StringBuilder sb = new StringBuilder();
		sb.append("SHIPPING ROUTES OUTPUT\n\n");
		int tc = Integer.parseInt(in.nextLine());
		for (int t = 0; t < tc; t++) {
			sb.append("DATA SET  "+(t+1)+"\n\n");
			int m = in.nextInt();
			int n = in.nextInt();
			int p = in.nextInt();
			ware = new boolean[m];
			tree = new TreeMap<String, Integer>();
			for (int i = 0; i < m; i++) {
				tree.put(in.next(), i);
			}
			mAdy = new int[m][m];
			
			for (int i = 0; i < n; i++) {
				String s = in.next();
				String d = in.next();
				for (int j = 0; j < m; j++) {
					if(i==j) mAdy[i][j]=-1;
					else{
						mAdy[tree.get(s)][tree.get(d)] = 1;
						mAdy[tree.get(d)][tree.get(s)] = 1;
					}
				}
			}
			
			for (int i = 0; i < p; i++) {
				int shipment = in.nextInt();
				int s = tree.get(in.next());
				int d = tree.get(in.next());
				int total = bfs( s,d,shipment );
				String cosa ="$"+total;
				if(total == -1){
					cosa = "NO SHIPMENT POSSIBLE";
				}
				sb.append(cosa+"\n");
				Arrays.fill(ware, false);
			}
			sb.append("\n");
		}
		sb.append("END OF OUTPUT\n");
		System.out.print(new String(sb));
	}
	
	public static int bfs( int s, int d, int shipment ){
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> costo = new LinkedList<Integer>();
		q.add(s);
		costo.add(0);
		ware[s]=true;
		while (!q.isEmpty()) {
			int a = q.poll();
			int c = costo.poll();
			
			if( a == d ){
				return shipment * c * 100;
			}else{
				for (int i = 0; i < mAdy.length; i++) {
					if( !ware[i] && mAdy[a][i] == 1 ){
						q.add(i);
						costo.add(c+1);
						ware[i]=true;
					}
				}
			}
		}
		return -1;
	}
}
