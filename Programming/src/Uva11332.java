
import java.io.*;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2307
 * @veredict Accepted
 * @problemId 11332
 * @problemName  Summing Digits
 * @judge http://uva.onlinejudge.org/
 * @category AdHoc - Recursion
 * @level Easy
 * @date 14/12/2012
 **/

public class Uva11332 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		for (String linea; (linea=in.readLine())!=null; ) {
			if(linea.equals("0")) break;
			sb.append(g(linea)+"\n");
		}
		System.out.print(new String(sb));
	}
	
	public static int g( String n )
	{
		if( Integer.parseInt(n)<10 )
			return Integer.parseInt(n);
		else{
			int sume = 0 ;
			for (int i = 0; i < n.length(); i++) {
				sume+=Integer.parseInt(n.charAt(i)+"");
			}
			return g(sume+"");
		}
	}
}
