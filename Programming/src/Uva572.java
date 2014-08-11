/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=29&page=show_problem&problem=36
 * @veredict Accepted 
 * @problemId 572
 * @problemName  Oil deposits
 * @judge http://uva.onlinejudge.org/
 * @category 
 * @level 2 
 * @date 08/08/2014
 **/ 


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Uva572 {
	
	static char[][] m;
	static boolean[][]v;
	static int []dx = { -1, -1, -1,  0,  0,  1,  1 , 1 };
	static int []dy = { -1,  0,  1, -1,  1, -1,  0 , 1 };
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line; (line=in.readLine())!=null; ) {
			StringTokenizer st = new StringTokenizer(line);
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if( r == 0 && c == 0 ) break;
			m = new char[r][c];
			v = new boolean[r][c];
			for (int i = 0; i < r; i++) {
				line = in.readLine();
				for (int j = 0; j < c; j++) {
					m[i][j] = line.charAt(j);
				}
			}
			sb.append(solve()).append("\n");
		}
		System.out.print(new String(sb));
	}
	
	public static int solve( ){
		int cant = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if( m[i][j]=='@'){
					floodfill( i, j, '@');
					cant++;
				}
			}
		}
		return cant;
	}
	
	public static void floodfill( int a, int b , char s ){
		Queue<Integer> xx = new LinkedList<Integer>();
		Queue<Integer> yy = new LinkedList<Integer>();
		xx.add(a);
		yy.add(b);
		v[a][b] = true;
		while( !xx.isEmpty() ){
			int x = xx.poll();
			int y = yy.poll();
			m[x][y] = '*';
			for (int k = 0; k < dx.length; k++) {
				int i = x + dx[k];
				int j = y + dy[k];
				if( i >= 0 && i < m.length && j >= 0 && j < m[0].length && !v[i][j] && m[i][j] == s ){
					xx.add(i);
					yy.add(j);
					v[i][j] = true;
				}
			}
		}
	}
}
