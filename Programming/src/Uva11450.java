import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Uva11450 {

	static int [][] g;
	static int [][][] l;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(in.readLine());
		for (int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int m = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			g = new int[c][];
			for (int i = 0; i < c; i++) {
				st = new StringTokenizer(in.readLine());
				int cant = Integer.parseInt(st.nextToken());
				g[i] = new int[cant];
				for (int j = 0; j < cant; j++) {
					g[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			l = new int[205][21][21];
			for (int i = 0; i < l.length; i++) {
				for (int j = 0; j < l[i].length; j++) {
					Arrays.fill(l[i][j], -1);
				}
			}
			int max = f( m, 0, 0 );
			sb.append( max>=0 ? max : "no solution" );
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}

	static int f( int m, int i, int j ){
		if( m < 0 ) return Integer.MIN_VALUE;
		else if( i == g.length && m >= 0) return 0;
		else if( i >= g.length ) return Integer.MIN_VALUE;
		else if( j >= g[i].length ) return Integer.MIN_VALUE;
		if( l[m][i][j] != -1 ) return l[m][i][j];
		else{
			int uno = f( m-g[i][j] , i+1, 0 ) + g[i][j];
			int dos = f( m, i, j+1 );
			return l[m][i][j] = Math.max(  uno  , dos );
		}
	}
	
}
