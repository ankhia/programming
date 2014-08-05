

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1474
 * @veredict Accepted 
 * @problemId 10533
 * @problemName  Digit Primes
 * @judge http://uva.onlinejudge.org/
 * @category Number Theory
 * @level easy
 * @date 27/03/2011
 **/ 

public class Uva10533 {
	static long[] digPrimos;
	static boolean[] criba;
	public static void main(String[] args) throws Throwable {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int max = 1000001;
		criba = new boolean[max];
		Arrays.fill(criba, true);
		digPrimos = new long[max];
		digPrimos[0]=digPrimos[1]=0;
		int cantDig=(int) digPrimos[0];
		for (int i = 2; i < criba.length; i++) {
			if(criba[i]){
				if(isDigitPrime(i))
					cantDig++;
				for (int j = (i*2); j < criba.length; j+=i) {
					criba[j] = false;
				}
			}
			digPrimos[i]=cantDig;
		}
		int casos = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for (int h = 0; h < casos; h++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int rango[]=new int[2];
			rango[0] = Integer.parseInt(st.nextToken())-1;
			rango[1] = Integer.parseInt(st.nextToken());
			Arrays.sort(rango);
			int respuesta = (int) (digPrimos[rango[1]] - digPrimos[rango[0]]);
			sb.append(respuesta);sb.append("\n");
		}
		System.out.print(sb);
	}
	static boolean isDigitPrime( int n ){
		if(n<10)
			return true;
		String numero = n+"";
		int suma =  0;
		for (int i = 0; i < numero.length(); i++) {
			suma+=Integer.parseInt(numero.charAt(i)+"");
		}
		return criba[suma];
	}
}
