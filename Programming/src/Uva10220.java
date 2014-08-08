

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1161
 * @veredict Accepted 
 * @problemId 10189
 * @problemName  I Love Big Numbers
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level easy
 * @date 13/11/2011
 **/
public class Uva10220 {
	
	static BigInteger fac[] ; 
	
	public static void main(String[] args) throws Throwable{
		
		fac = new BigInteger[1001];
		fac[0]=BigInteger.ZERO;
		fac[1]=BigInteger.ONE;
		fac[2]=BigInteger.valueOf(2);
		for (int i = 3; i < fac.length; i++) {
			fac[i]=BigInteger.valueOf(i).multiply(fac[i-1]);
		}
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line; (line=in.readLine())!=null; ) {
			int num = Integer.parseInt(line);
			String a = fac[num]+"";
			int suma = 0;
			for (int i = 0; i < a.length(); i++) {
				suma+=Integer.parseInt(a.charAt(i)+"");
			}
			sb.append(suma+"\n");
			suma=0;
		}
		System.out.print(new String(sb));
	}	
}
