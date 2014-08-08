

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva10539 {


	static boolean criba[];


	public static void main(String[] args) throws Throwable {
		criba = new boolean[1000001];
		criba[0] = true;
		criba[1] = true;
		for(int i = 2; i*i <= criba.length-1; ++i) {
			if(!criba[i]) {
				for(int h = 2; i*h <= criba.length-1; ++h)
					criba[i*h] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			BigInteger l = new BigInteger(st.nextToken());
			BigInteger h = new BigInteger(st.nextToken());
			long cont = 0;
			boolean termine = false;
			for(int j = 2; j<criba.length; j++){
				if(!criba[j]){
					BigInteger exp = BigInteger.valueOf(j);
					BigInteger a = exp;
 					exp = exp.multiply(a);
					if(exp.compareTo(h) == 1) break;
					while( exp.compareTo(h) == -1 || exp.compareTo(h) == 0 ){
						if(exp.compareTo(l) == 0 || exp.compareTo(l) == 1){
							cont++;	
							exp = exp.multiply(a);
						}
					}
				}
			}
			sb.append(cont+"\n");
		}
		System.out.print(new String(sb));
	}
}
