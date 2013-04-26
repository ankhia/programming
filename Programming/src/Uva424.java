

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=365
 * @veredict Accepted 
 * @problemId 424
 * @problemName Integer Inquiry
 * @judge http://uva.onlinejudge.org/
 * @category AdHoc
 * @level easy
 * @date 21/12/2011
 **/

public class Uva424 {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BigInteger suma  = BigInteger.ZERO;
		for ( String linea ;!(linea=in.readLine()).equals("0");) {
			BigInteger b = new BigInteger(linea);
			suma = suma.add(b);
		}
		System.out.println(suma);
	}

}
