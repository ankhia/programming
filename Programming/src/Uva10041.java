

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva10041 {

	static int[] v;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int cases = 0; cases < casos; cases++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int cant = Integer.parseInt(st.nextToken());
			v = new int[cant];
			for (int i = 0; i < cant; i++) 	v[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(v);
			int median;
			if(v.length%2==0){
				int a = (v.length/2);
				median = (v[a]+v[a-1])/2;
			}else{
				int a = (v.length/2);
				median = v[a];
			}
			int suma = 0;
			for (int i = 0; i < v.length; i++) {
				suma+= Math.abs(v[i]-median);
			}
			sb.append(suma+"\n");
		}
		System.out.print(new String(sb));
	}

}
