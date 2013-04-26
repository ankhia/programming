

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1051
 * @veredict Accepted 
 * @problemId 10110
 * @problemName Light, more light
 * @judge http://uva.onlinejudge.org/
 * @category AdHoc
 * @level easy
 * @date 21/12/2011
 **/

public class Uva10110 {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (long i ; (i = Long.parseLong(in.readLine()))!= 0; ) {
			double a = Math.sqrt(i);
			int b = (int)a;
			if(Math.abs(b-a)>1e-6)
				System.out.println("no");
			else
				System.out.println("yes");
		}
	}
}
