

import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=305
 * @veredict Accepted 
 * @problemId 369
 * @problemName Combinations
 * @judge http://uva.onlinejudge.org/
 * @category Math
 * @level easy
 * @date 09/08/2012
 **/
public class Uva369 {

	static BigInteger m[][];
	
	public static void main(String[] args) throws Throwable {
		
		m = new BigInteger[101][102];
		for (int i = 0; i < m.length; i++) 
			Arrays.fill(m[i], BigInteger.valueOf(-1));
		
		for (int i = 0; i < m.length; i++) {
			boolean termine = false;
			for (int j = 0; j < m[0].length && !termine; j++) {
				if(j==0) m[i][j]=BigInteger.ONE;
				else if( i-1 >= 0 && j-1 >= 0 ){
					if(m[i-1][j].compareTo(BigInteger.ZERO)==1)
						m[i][j] = m[i-1][j-1].add(m[i-1][j]);
					else {
						m[i][j] = BigInteger.ONE;
						termine = true;
					}
				}
			}
		}

//		for (int i = 0; i < m.length; i++) {
//			System.out.println(Arrays.toString(m[i]));
//		}
		
		StringBuilder sb = new StringBuilder();
		Scanner in = new Scanner(new InputStreamReader(System.in));
		int a = in.nextInt();
		int b = in.nextInt();
		while( a!=0 && b!=0 ){
			
			if(m[a][b]!=BigInteger.valueOf(-1))
				sb.append(a+" things taken "+b+" at a time is "+m[a][b]+" exactly.\n");
			a = in.nextInt();
			b = in.nextInt();
		}
		System.out.print(new String(sb));
	}
}
