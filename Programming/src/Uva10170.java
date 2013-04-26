

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1111
 * @veredict Accepted 
 * @problemId 10170 
 * @problemName The Hotel with Infinite Rooms
 * @judge http://uva.onlinejudge.org/
 * @category Ac
 * @level easy
 * @date 10/12/2012
 **/ 

public class Uva10170 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		while((linea=in.readLine())!=null){
			StringTokenizer st = new StringTokenizer(linea);
			long n = Long.parseLong(st.nextToken());
			long day = Long.parseLong(st.nextToken());
			long a = 0;
			while( a < day){
				a = a + n;
				n++;
			}
			System.out.println(n-1);
		}
	}
}
