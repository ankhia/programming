

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=516
 * @veredict Accepted 
 * @problemId 575
 * @problemName  The Blocks Problem
 * @judge http://uva.onlinejudge.org/
 * @category AdHoc
 * @level easy
 * @date 16/05/2012
 **/

public class Uva575 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String linea; !(linea = in.readLine()).equals("0"); ) {
			int suma = 0;
			int tam = linea.length();
			for (int i = 0; i < linea.length(); i++) {
				suma += Integer.parseInt(linea.charAt(i)+"")*( Math.pow(2, tam)- 1 );
				tam--;
			}
			System.out.println(suma);
		}
	}
}
