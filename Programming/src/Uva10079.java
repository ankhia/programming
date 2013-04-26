

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&category=24&problem=1020
 * @veredict Accepted 
 * @problemId 10079
 * @problemName  Pizza Cutting
 * @judge http://uva.onlinejudge.org/
 * @category Math, 
 * @level easy
 * @date 06/12/2012
 **/ 

public class Uva10079 {

	public static void main(String[] args) throws Throwable
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for( String linea; (linea = in.readLine())!=null; ){
			long n = Integer.parseInt(linea);
			if(n<0) break;
			long formula = (n*(n+1)+2)/2;
			sb.append(formula+"\n");
		}
		System.out.print(new String(sb));
	}
}
