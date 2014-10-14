import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Uva1213 {

	static int maxInt = 1500;
	static boolean isPrime[];
	static List<Integer> primes;
	static int[][][] mem ;
	static int[] waysByNumber;
	public static void main(String[] args) throws Throwable {
		isPrime = new boolean[maxInt];
		primes = new ArrayList<Integer>();
		init( );
		mem = new int[15][1121][1500];
		for (int i = 0; i < mem.length; i++) {
			for (int j = 0; j < mem[i].length; j++) {
				Arrays.fill(mem[i][j], -1);
			}
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line; (line = in.readLine())!=null; ) {
			StringTokenizer st = new StringTokenizer(line);
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			if( n==0 && k == 0 ) break;
			sb.append( f ( n, k, 0 ) ).append("\n");
		}
		System.out.print( new String(sb) );
	}
	
	public static int f( int n, int k, int i ){
		if( n==0 && k == 0 ) return mem[k][n][i]=1;
		else if( n <= 0 || k <= 0 || i >= primes.size() ) return 0;
		else if( mem[k][n][i] != -1) return mem[k][n][i];
		else return mem[k][n][i]=f( n-primes.get(i), k-1, i+1 ) + f( n, k, i+1 );
	}
	
	public static void init( ){
		for (int i = 2; i < maxInt; i++) {
			if( !isPrime[i] ){
				for (int j = i*i; j < maxInt; j+=i) {
					isPrime[j] = true;
				}
				primes.add(i);
			}
		}
	}
}
