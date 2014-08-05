import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Uva10360 {

	static int d;
	static int m[][];
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int scen = Integer.parseInt(in.readLine());
		m = new int[1025][1025];
		for (int t = 0; t < scen; t++) {
			for (int i = 0; i < m.length; i++) {
				Arrays.fill(m[i], 0);
			}
			d = Integer.parseInt(in.readLine());
			int p = Integer.parseInt(in.readLine());
			for (int i = 0; i < p; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				m[x][y]=v;
			}
			
			dinamicaSumMatriz();
			
			int max = Integer.MIN_VALUE;
			int x = -1;
			int y = -1;
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					int a;
					int b;
					int I;
					int J;
					if( i-d >= 0 )
						a = i-d;
					else 
						a = 0;
					if( j-d >=0 )
						b = j-d;
					else
						b = 0;
					if( i+d < m.length )
						I = i+d;
					else
						I = m.length-1;
					if( j+d < m[i].length )
						J = j+d;
					else J = m[i].length-1;
					
					int totalRatasMuertas = result(a, b, I, J);
					
					if( totalRatasMuertas > max ) {
						max = totalRatasMuertas;
						x = i;
						y = j;
					}
				}
			}
			sb.append(x +" " + y + " "+ max+"\n");
		}
		System.out.print(new String(sb));
	}

	public static int result( int a , int b , int i , int j ){
		if( a==0&&b==0 ) return m[i][j];
		else if(a == 0) return m[i][j] - m[i][b-1];
		else if(b == 0) return m[i][j] - m[a-1][j];
		else return m[i][j] - m[i][b-1] - m[a-1][j] + m[a-1][b-1];
	}
	
	public static void dinamicaSumMatriz( ){
		for (int i = 1; i < m.length; i++) {
			m[i][0] += m[i-1][0];
		}
		for (int i = 1; i < m[0].length; i++) {
			m[0][i] += m[0][i-1];
		}
		
		for (int i = 1; i < m.length; i++) {
			for (int j = 1; j < m[i].length; j++) {
				m[i][j]+=m[i-1][j]+m[i][j-1]-m[i-1][j-1];
			}
		}
	}

}
