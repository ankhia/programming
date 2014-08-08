import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Uva374 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line; (line = in.readLine())!=null; ) {
			int B = Integer.parseInt(line);
			int P = Integer.parseInt(in.readLine());
			int M = Integer.parseInt(in.readLine());
			sb.append( pot(B, P, M) +"\n");
			in.readLine();
		}
		System.out.print(new String(sb));
	}
	
	public static int pot( int a , int b , int  m)
	{
		if( b == 0 ) return 1;
		else if( b%2==0 ){
			int q = pot( a, b/2, m );
			return (( q % m ) * ( q % m )) % m ;
		}else{
			int q = pot( a, (b-1)/2, m);
			return ( ( ( ( q%m )*( q%m ) ) % m ) *( a%m ) ) % m ;
		}
			
	}
}
