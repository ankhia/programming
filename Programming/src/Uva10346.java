import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva10346 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		for (String line; (line = in.readLine())!=null ; ) {
			StringTokenizer st = new StringTokenizer(line);
			long n = Integer.parseInt(st.nextToken());
			long k = Integer.parseInt(st.nextToken());
			sb.append(solve(n,k)+"\n");
		}
		System.out.print(new String(sb));
	}
	
	private static long solve(long n, long k) {
		long sum = n;
		while( n >= k ){
			long res = (long) Math.floor(n%k); 
			sum += n/=k ;
			n+= res;
		}
		return sum;
	}
}


//private static long solve(long n, long k ){
//long cont = n;
//long col = n;
//while(col >= k){
//	cont++;
//	col-=k;
//	col++;
//}
//return cont;
//}