

import java.io.*;
import java.util.*;

public class Uva573 {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String linea; (linea=in.readLine())!=null;) {
			StringTokenizer st = new StringTokenizer(linea);
			int H = Integer.parseInt(st.nextToken());
			double U = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int F = Integer.parseInt(st.nextToken());
			if( H == 0 && U == 0 && D== 0 && F==0) break;
			
			double fac = ( F * U ) / 100;
			double alt = U;
			int day = 1;
			while( alt >= 0 && alt <= H ){
				alt -= D;
				if(alt<0)break;
				U=Math.max(U-fac,0);
				alt += U ;
				day++;
			}
			if(alt>H) System.out.println("success on day "+day);
			else System.out.println("failure on day "+day);
		}
	}
}
