import java.io.InputStreamReader;
import java.util.*;


public class Acm5733 {

	static long[] num;
	public static void main(String[] args) throws Throwable {
		Scanner in = new Scanner(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		int tc = 1;
		for ( int line ; (line = in.nextInt()) != 0; tc++) {
			int n = line;
			if( n == 0 ) break;
			sb.append("Case "+tc+": ");
			num = new long[n];
			boolean iguales = true;
			for (int i = 0; i < n; i++) {
				num[i] = in.nextLong();
				if( i>0 && num[i] != num[i-1] ) iguales = false;
			}
			int iteraciones = 0;
			while(!iguales && iteraciones<=1000){
				iguales = true;
				long[] copy = num.clone();
				for (int i = 0; i < n; i++) {
					num[ i ] = Math.abs( copy[ i ] - copy[ (i+1)%n ] );
					if( i > 0 && num[i]!=num[i-1] ) iguales = false;
				}
				iteraciones++;
			}
			if(iteraciones<=1000)
				sb.append( iteraciones +" iterations\n");
			else
				sb.append("not attained\n");
		}
		System.out.print( new String( sb ) );
	}
}