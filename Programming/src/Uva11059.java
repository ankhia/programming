

import java.io.*;
import java.util.StringTokenizer;
import static java.lang.Integer.*;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2000
 * @veredict Accepted 
 * @problemId 11059
 * @problemName  Maximum Product
 * @judge http://uva.onlinejudge.org/
 * @category DP
 * @level easy
 * @date 11/12/2012
 **/

public class Uva11059 {


	static int num[];
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String linea; (linea=in.readLine())!=null; ) {
			int n = parseInt(linea);
			StringTokenizer st = new StringTokenizer(in.readLine());
			num = new int[n];
			for (int i = 0; i < n; i++) {
				num[i]=parseInt(st.nextToken());
			}

//			int max = Integer.MIN_VALUE;
//			for (int i = 0; i < num.length; i++) {
//				max = Math.max(max, f(i));
//			}
			
			int max = f(0);
			
			System.out.println(max);

			in.readLine();
		}
	}

	public static int f( int i ) {			
		if ( i<num.length && num[i]>0)
			return Math.max(f(i+1), Math.max(num[i]*f(i+1), num[i]));
		else if( i<num.length && num[i]<0)
			return f(i+1);
		else
			return Integer.MIN_VALUE;
	}
}
