/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://livearchive.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=94&page=show_problem&problem=325
 * @veredict Accepted 
 * @problemId 2324
 * @problemName  Finding Seats
 * @judge http://uva.onlinejudge.org/
 * @category DP
 * @level Easy
 * @date 27/04/2012
 **/

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Acm2324 {

	static int m[][] ;
	static int mem[][];
	static HashMap<String, Integer> letras;
	static int nUno;
	static int nDos;
	static String uno; 
	static String dos; 
	
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		mem = new int[105][105];
		m = new int [][]{   new int[]{ 5,-1,-2,-1,-3 }, 
							new int[]{-1, 5,-3,-2,-4 },
							new int[]{-2,-3, 5,-2,-2 },
							new int[]{-1,-2,-2, 5,-1 },
							new int[]{-3,-4,-2,-1,Integer.MIN_VALUE}};
		letras = new HashMap<String, Integer>();
		letras.put("A", 0 );
		letras.put("C", 1 );
		letras.put("G", 2 );
		letras.put("T", 3 );
		letras.put("-", 4 );
		
		int casos = Integer.parseInt(in.readLine());
		for (int i = 0; i < casos; i++) {
			
			
			for (int j = 0; j < mem.length; j++) {
				Arrays.fill(mem[j], MIN_VALUE);
			}
			
			String[] lineaUno = in.readLine().split(" ");
			nUno = parseInt(lineaUno[0]);
			uno = lineaUno[1];
			String[] lineaDos = in.readLine().split(" ");
			nDos = parseInt(lineaDos[0]);
			dos = lineaDos[1];
			System.out.println(g(0,0));
//			System.out.println(g(0,0)+" - " +f(0,0));
//			for (int j = 0; j < 10; j++) {
//				System.out.println(Arrays.toString(mem[j]));
//			}
		}
	}
	
	
	static int g( int i , int j ){
		if( mem[i][j]!=Integer.MIN_VALUE )
			return mem[i][j];
		int esp = letras.get("-");
		if(i==nUno){
			int suma =0;
			for (int j2 = j; j2 < nDos; j2++) {
				suma+= m[letras.get(dos.charAt(j)+"")][esp];
			}
			return mem[i][j]=suma;
		}
		if(j==nDos){
			int suma = 0;
			for (int j2 = i; j2 < nUno; j2++) {
				suma+= m[letras.get(uno.charAt(i)+"")][esp];
			}
			return mem[i][j]=suma;
		}
		int a = letras.get(uno.charAt(i)+"");
		int b = letras.get(dos.charAt(j)+"");
		return mem[i][j] = max( g(i+1,j+1)+ m[a][b], max( g(i+1,j)+m[a][esp], g(i, j+1)+m[b][esp] ));
	}
	
//	static int f( int i , int j ){
//		
//		int esp = letras.get("-");
//		if(i==nUno){
//			int suma =0;
//			for (int j2 = j; j2 < nDos; j2++) {
//				suma+= m[letras.get(dos.charAt(j)+"")][esp];
//			}
//			return suma;
//		}
//		if(j==nDos){
//			int suma = 0;
//			for (int j2 = i; j2 < nUno; j2++) {
//				suma+= m[letras.get(uno.charAt(i)+"")][esp];
//			}
//			return suma;
//		}
//		
//		int a = letras.get(uno.charAt(i)+"");
//		int b = letras.get(dos.charAt(j)+"");
//		return max( f(i+1,j+1)+ m[a][b], max( f(i+1,j)+m[a][esp], f(i, j+1)+m[b][esp] ));
//	}
}
