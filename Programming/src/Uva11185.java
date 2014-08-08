

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Uva11185 {

	public static void main(String[] args) throws Throwable {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		for (String linea ; (linea=in.readLine())!=null ;) {
//			int num = Integer.parseInt( linea );
//			if(num==-1)break;
//			BigInteger a = new BigInteger(linea);
//			System.out.println(a.toString(3));
//		}
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String linea ; (linea=in.readLine())!=null ;) {
			int num = Integer.parseInt( linea );
			if(num<0)break;
			System.out.println(Integer.toString(num, 3));
//			System.out.println(Long.toString(num, 3));
		}

		
	}

}
