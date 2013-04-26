

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2947
 * @veredict Accepted 
 * @problemId 11847
 * @problemName  Cut the Silver Bar
 * @judge http://uva.onlinejudge.org/
 * @category AC, Math
 * @level easy
 * @date 13/04/2012
 **/ 

public class Uva11847 {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String linea; (linea = in.readLine())!=null; ) {
			int numer = Integer.parseInt(linea);
			if(numer==0)break;
			System.out.println((int)(Math.log(numer)/Math.log(2)));
		}
	}

}
