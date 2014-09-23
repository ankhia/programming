import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CodeForces466A {

	static int n , a, b , m;
	static long v[];
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(String line ; (line=in.readLine())!=null; ){
			StringTokenizer st = new StringTokenizer(line);
			n = Integer.parseInt(st.nextToken()) ; m = Integer.parseInt(st.nextToken()); a  = Integer.parseInt(st.nextToken()) ; b  = Integer.parseInt(st.nextToken()) ;
			v = new long[1005];
			Arrays.fill(v, -1);
			v[0] = 0;
			sb.append(f(n)).append("\n");
		}
		System.out.print(new String(sb));
	}
	
	public static long f( int i ){
		if( i >= 0 && i < v.length && v[i]!=-1)
			return v[i];
		if( i <= 0 )
			return 0;
		else
			return v[i]=Math.min( f(i-m) + b , f(i-1)+a ); 
	}

}
