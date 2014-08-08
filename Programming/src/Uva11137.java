

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2078
 * @veredict Accepted 
 * @problemId 11137
 * @problemName Ingenuous Cubrency
 * @judge http://uva.onlinejudge.org/
 * @category 
 * @level easy 
 * @date 06/12/2012
 **/

public class Uva11137 {

	static int mon[];
	static long[][] mat;
	public static void main(String[] args) throws Throwable {
		
		mon = new int[22];
		for (int i = 0; i < mon.length;) {
			i++;
			mon[i-1]=i*i*i;
		}
//		System.out.println(Arrays.toString(mon));
		mat = new long[10001][22];
		for(int i=0;i<mat.length;++i){
			for(int j=0;j<mat[i].length;++j){
				if(i==0)mat[i][j]=1;
//				System.out.println(mon[j] + " " + i);
				if(mon[j]>i)mat[i][j]=10;
			}
		}
		
		for (int i = 0; i < mat.length; i++) {
			f(i,0);
		}
		
		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
		StringBuilder sb = new StringBuilder();
		for (String linea; (linea=in.readLine())!=null; ) {
			
			int n = Integer.parseInt(linea.trim());
			
			long sol = f( n, 0 );
			sb.append(sol+"\n");
		}
		System.out.print(new String(sb));
	}
	public static long f( int n, int i ){
		if( i >= mon.length || n < 0 ) return 0;
		if( n == 0 ) return 1;
		if( n<mon[i]) return 0;
		else if( mat[n][i] != 0 ) 	return mat[n][i];
		else return mat[n][i]=f(n,i+1)+f(n-mon[i],i);
	}
}
