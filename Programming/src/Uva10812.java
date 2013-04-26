

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1753
 * @veredict  Accepted
 * @problemId 10812
 * @problemName Beat the Spread!
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 24/12/2012
 **/

public class Uva10812 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(in.readLine());
		for (int c = 0; c < casos; c++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int x = (a+b)/2;
			int y = Math.abs(x-b);
			if(x+y==a && Math.abs(x-y)==b) 
				System.out.println(Math.max(x, y)+" "+Math.min(x, y));
			else
				System.out.println("impossible");
		}
	}
}
