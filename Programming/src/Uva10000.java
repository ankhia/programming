

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&category=&problem=941&mosmsg=Submission+received+with+ID+11394701
 * @veredict Accepted 
 * @problemId 10000
 * @problemName Longest Paths
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level madium
 * @date 06/03/2013
 **/

public class Uva10000 {

	static double[][] mAdy;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cas = 1;
		for (String line; (line=in.readLine())!=null; cas++ ) {
			int n = Integer.parseInt(line);
			if(n==0) break;
			int s = Integer.parseInt(in.readLine());
			mAdy = new double[n][n];
			for (int i = 0; i < mAdy.length; i++) {
				for (int j = 0; j < mAdy[i].length; j++) {
					mAdy[i][j]=Integer.MIN_VALUE;
				}
			}
			for (StringTokenizer st; (st = new StringTokenizer(in.readLine()))!=null; ) {
				int a = Integer.parseInt(st.nextToken( ));
				int b = Integer.parseInt(st.nextToken( ));
				if(a==0 && b == 0) break;
				mAdy[a-1][b-1] = 1;
			}
			mAdy = floydWarshall(mAdy);
			int max = Integer.MIN_VALUE;
			int nodoEnd = -1;
			for (int i = 0; i < mAdy.length; i++) {
				if( mAdy[s-1][i] > max ){
					max = (int) mAdy[s-1][i];
					nodoEnd = i;
				}
			}
			sb.append("Case "+cas+": The longest path from "+s+" has length "+max+", finishing at "+(nodoEnd+1)+".\n\n");
		}
		System.out.print( new String(sb) );
	}

	static double[][] floydWarshall(double[][] mAdy) { 
		int n=mAdy.length; double x[][]=new double[n][n]; 
		for (int i=0; i<n; i++) System.arraycopy(mAdy[i],0,x[i],0,n); 
		for (int k=0; k<n; k++) for (int i=0; i<n; i++) for (int j=0; j<n; j++) 
			x[i][j]=Math.max(x[i][j],x[i][k]+x[k][j]); 
		return x; 
	}
}

//static void floydWarshall(  ) {
//for (int k = 0; k < fw.length; k++) {
//	for (int i = 0; i < fw.length; i++) {
//		for (int j = 0; j < fw.length; j++) {
//			fw[i][j] = Math.max(fw[i][j], fw[i][k]+fw[k][j]);
//		}
//		
//	}
//}
//}
