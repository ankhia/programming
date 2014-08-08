

import static java.lang.Integer.parseInt;

import java.io.*;
import java.util.ArrayList;

public class Uva10323 {

	public static void main(String[] args) throws Throwable {

		ArrayList<Long> array = new ArrayList<Long>();
		array.add(1l);
		array.add(1l);
		int i = 2 ;
		long res;
		do {
			res = array.get(i-1)*i;
			array.add(res);
			i++;
		}while(res <= 6227020800l);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String line; (line = in.readLine())!=null; ) {
			int a = parseInt(line);
			if( a < 0 ){
				if(Math.abs(a)%2==0) System.out.println("Underflow!"); 
				else System.out.println("Overflow!");
			}else if( a >= array.size() || (a<array.size()&&array.get(a)>6227020800l))
				System.out.println("Overflow!");
			else if(array.get(a)<10000)
				System.out.println("Underflow!");
			else
				System.out.println(array.get(a));
		}
	}

}
