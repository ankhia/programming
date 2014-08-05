

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2201
 * @veredict Accepted 
 * @problemId 11244
 * @problemName  Counting Stars
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level easy
 * @date 12/11/2011
 **/

public class Uva11244 {

	static char [][]m ;
	static int r;
	static int c;
	static int dx[]=new int[]{-1,-1,-1,0,0,1,1,1};
	static int dy[]=new int[]{-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String linea; (linea=in.readLine())!=null;) {
			StringTokenizer st = new StringTokenizer(linea);
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if( r == 0 && c == 0 ) break;
			m = new char[r][c];
			for (int i = 0; i < r; i++) {
				linea = in.readLine();
				for (int j = 0; j < c; j++) {
					m[i][j] = linea.charAt(j);
				}
			}

			//			imprimirMat();
			int contStar = 0;
			boolean star = false;
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					if(m[i][j]=='*'){
//						System.out.println( i + " - " + j  + " :  " + m[i][j]);
//						System.out.println("------------------------------------");
						star = true;
						for (int k = 0; k < dx.length && star; k++) {
							if( i+dx[k]>=0 && j+dy[k]>=0 && i+dx[k] < r && j+dy[k] < c  ){
//								System.out.println( (i+dx[k]) + " - " + (j+dy[k]) + " :  " + m[(i+dx[k])][(j+dy[k])]);
								if( m[(i+dx[k])][(j+dy[k])]=='*')
									star = false;
							}
						}
						if(star) contStar++;
					}
				}
			}
			sb.append(contStar+"\n");
		}
		System.out.print(new String(sb));
	}

	static void imprimirMat(  ){
		for (int i = 0; i < m.length; i++) {
			System.out.println(Arrays.toString(m[i]));
		}
	}
}
