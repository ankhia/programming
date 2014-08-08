

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Uva10530 {
	
	static boolean v[];

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for( String linea; (linea = in.readLine() ) != null ; ) {
			v = new boolean[12];
			int guess = Integer.parseInt(linea);
			if(guess == 0) break;
			String resp = in.readLine();
			while( !resp.equals("right on") ){
				if( resp.equals("too high") )
					for (int i = guess; i < v.length; i++) 
						v[i]=true;
				else
					for (int i = guess; i >= 0; i--) 
						v[i] = true;
				guess = Integer.parseInt(in.readLine());
				resp = in.readLine();
			}
			if( v[guess] )
				System.out.println("Stan is dishonest");
			else
				System.out.println("Stan may be honest");
		}
	}
}


//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Uva10530 {
//
//	public static void main(String[] args) throws Throwable {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		for (String line; (line = in.readLine())!=null; ) {
//			int n = Integer.parseInt(line);
//			if(n==0)break;
//			line = in.readLine();
//			int max = 11;
//			int min = 0;
//			
//			while(!line.equals("right on")){
//				if(line.equals("too high")){
//					if( n<max ){ max=n; }
//				}else{ 
//					if( n>min ) min = n;
//				}
//				n = Integer.parseInt(in.readLine());
//				line = in.readLine();
//			}
//			if( max-min <= 1 || n < min || n > max){
////				System.out.println(Math.abs(max-min)<=1);
////				System.out.println(min > max);
////				System.out.println(n < min);
////				System.out.println(n > max);
////				System.out.println(n + "   " + min+ "    " + max);
//				System.out.println("Stan is dishonest");
//			}else{
//				System.out.println("Stan may be honest");
//			}
//		}
//	}
//}

