

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Acm3026 {


	static int b[];
	static int m;
	static String pat;
	static int n;
	static String T;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int casos = 1;
		for (String linea; (linea = in.readLine())!=null ; casos++) {
			m = Integer.parseInt(linea);
			if(m == 0) break;
			pat = in.readLine();
			b = new int[pat.length()+1];
			T= pat+pat;
			System.out.println("T: " + T);
			n=T.length();
			bordes();
			for (int i = 0; i < b.length; i++) {
				System.out.print(b[i]+" ");
			}
			System.out.println();
			kmp();
		}

	}

	static void bordes( ){
		int i = 0, j=-1; b[0] = -1;
		while( i < m ){
			while( j >= 0 && pat.charAt(i)!= pat.charAt(j)) j = b[j];
			i++;j++;
			b[i]=j;
		}
	}
	
	static void kmp( ){
		int i = 0 , j = 0;
		while( i < n ){
			while( j >= 0 && T.charAt(i)!=pat.charAt(j)) j=b[j];
			i++;j++;
			if(j == m){
				if(b[i-j]>=0){
				 System.out.printf("Tam Prefijo: %d - Periodo:  %d\n", (i-j), pat.length()/(i-j));
				}
				j = b[j];
			}
		}
	}
}
