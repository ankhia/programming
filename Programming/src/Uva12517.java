

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=3962
 * @veredict Accepted 
 * @problemId 12517 
 * @problemName Digit Sum
 * @judge http://uva.onlinejudge.org/
 * @category Math
 * @level easy
 * @date 10/12/2012
 **/ 

public class Uva12517 
{

	public static void main(String[] args) throws Throwable
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String linea; (linea=in.readLine())!=null;) {
			StringTokenizer st = new StringTokenizer(linea);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==0&&b==0) break;

			System.out.println((f(b)-f(a-1)));
		}
	}

	public static long f( int x ) {
		long suma = 0;
		String num = x+"";

		if( x < 10 ){
			int hastaI = 0;
			for (int j = 1; j <= x; j++) 
				hastaI += j;
			suma += hastaI;
		} else {

			for (int i = num.length()-1 , k = 0 ; i >=0 ; i--, k++) {
				int act = Integer.parseInt(num.charAt(i)+"");
				//			act = num.length()>1?act--:act;
				long pot = (long) Math.pow(10, k);
				int b=-1;
				if( i-1 >= 0 )
					b = Integer.parseInt(num.substring(0, i));		
				if(b!=-1)
					suma += b*pot*45;
				
				int hastaI = 0;
				if( pot == 1 ){
					for (int j = 1; j <= act; j++) 
						hastaI += j;
				}else{
					for (int j = 1; j < act; j++) 
						hastaI += j;
				}
				suma += hastaI*pot;

				int a=-1;
				if( i+1 < num.length() )
					a = Integer.parseInt(num.substring(i+1, num.length()));
				if( a!=-1 )
					suma+= act*(a+1);
			}
		}
		return suma;
	}
}
