

import java.io.*;
import java.util.*;

public class Uva11364 {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int casos = Integer.parseInt(in.readLine());
		for (int c = 0; c < casos; c++) {
			int casitos = Integer.parseInt(in.readLine());
			int vec[]  = new int[casitos];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int c1 = 0; c1 < casitos; c1++) {
				vec[c1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(vec);
			if (vec.length > 1) {
				int suma = 0;
				for (int i = 1 ; i < vec.length; i++)
						suma += (Math.abs((vec[i]-vec[i-1])))*2;
				sb.append(suma+"\n");
			}else{
				sb.append("0\n");
			}
		}
		System.out.print(new String(sb));
	}
}
