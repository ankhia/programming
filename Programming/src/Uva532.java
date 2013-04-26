

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Uva532 {

	static int []dx = new int[]{  0,  0,  0, 0, 1, -1};
	static int []dy = new int[]{ -1,  0,  0, 1, 0,  0 };
	static int []dz = new int[]{  0,  1, -1, 0, 0,  0 };
	static int xS, yS,zS;
	static int xE, yE,zE;
	static int l, r, c;
	static char m[][][];
	static boolean v[][][];
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line;(line = in.readLine())!=null; ) {
			StringTokenizer st = new StringTokenizer(line);
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if( l==0 && r == 0 && c == 0 ) break;
			m = new char[l][r][c];
			v = new boolean[l][r][c];
			xS = -1; yS = -1; zS = -1;
			xE = -1; yE = -1; zE = -1;
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < r; j++) {
					line = in.readLine( );
					for (int k = 0; k < c; k++) {
						m[i][j][k] = line.charAt(k);
						if( m[i][j][k] == 'S' ){
							xS = i;yS=j;zS=k;
						}
						if( m[i][j][k] == 'E' ){
							xE = i;yE=j;zE=k;
						}
					}
				}
				in.readLine( );
			}

			int tiempo = BFS( );
			if(tiempo == -1)
				sb.append("Trapped!\n");
			else
				sb.append("Escaped in " + tiempo + " minute(s).\n" );
		}
		System.out.print(new String(sb));
	}

	public static int BFS( ) {
		
		int finnish = -1;
		Queue<Integer> min = new LinkedList<Integer>();
		Queue<Integer> x = new LinkedList<Integer>();
		Queue<Integer> y = new LinkedList<Integer>();
		Queue<Integer> z = new LinkedList<Integer>();

		x.add(xS);
		y.add(yS);
		z.add(zS);
		min.add(0);

		while( !x.isEmpty() ){
			int xA = x.poll();
			int yA = y.poll();
			int zA = z.poll();
			int t = min.poll();
			if(xA == xE && yA == yE && zA == zE ){
				finnish = t;
				break;
			}else{
				for(int j = 0; j<dx.length; j++){
					if( xA + dx[j] >= 0 && xA + dx[j] < l && yA + dy[j] >= 0 && zA +dz[j] >= 0 && yA + dy[j] < r && zA + dz[j] < c ){
						if( !v[xA+dx[j]][yA+dy[j]][zA+dz[j]] && m[xA+dx[j]][yA+dy[j]][zA+dz[j]]!='#' ){
							v[xA+dx[j]][yA+dy[j]][zA+dz[j]] = true;
							x.add(xA+dx[j]);
							y.add(yA+dy[j]);
							z.add(zA+dz[j]);
							min.add(t+1);
						}
					}
				}
			}
		}
		return finnish;
	}

	public static void imprimir( ){
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				for (int j2 = 0; j2 < m[i][j].length; j2++) {
					System.out.println(m[i][j][j2]);
				}

			}
		}
	}
}
