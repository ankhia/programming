import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva11559 {
	
	static int n;
	static int b;
	static int h;
	static int w;
	static int[] hotels;
	static int[][] weekends;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String line; (line = in.readLine())!=null; ) {
			StringTokenizer  st = new StringTokenizer(line);
			 n = Integer.parseInt(st.nextToken());
			 b = Integer.parseInt(st.nextToken());
			 h = Integer.parseInt(st.nextToken());
			 w = Integer.parseInt(st.nextToken());
			hotels = new int[h];
			weekends = new int[h][w];
			for (int i = 0; i < h; i++){ 
				hotels[i] = Integer.parseInt(in.readLine());
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < w; j++) {
					weekends[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			solve();
		}
	}
	
	private static void solve( ) {
		StringBuilder sb = new StringBuilder( );
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < h; i++) {
			if( (hotels[i] * n) <= b ){
				for (int j = 0; j < w; j++) {
					if( weekends[i][j] >= n )
						min = Math.min(min, hotels[i]*n);
				}
			}
		}
		if( min == Integer.MAX_VALUE)
			sb.append("stay home\n");
		else
			sb.append(min).append("\n");
		System.out.print(new String(sb));
	}
}
