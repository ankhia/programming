

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Uva11150 {

	static int []v; 
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
		v = new int[201];
		v[0]=0;
		v[1]=1;
		v[2]=3;
		for (int i = 0; i < v.length; i++) {
			int div = i/3;
			int res = i%3;
			int la = div + res;
			v[i]=(3*div)+v[la];
		}
		
		for (String linea; ( linea = in.readLine() ) != null; ) {
			int a = Integer.parseInt(linea);
			System.out.println(v[a]);
		}
	}
}
