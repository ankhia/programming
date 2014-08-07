import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Acm5737 {

	static long [][]mem;
	public static void main(String[] args) throws Throwable {
		mem = new long[100][100];
		for (int i = 0; i < mem.length; i++) {
			Arrays.fill(mem[i], -1);
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		for (String line; (line = in.readLine())!=null; ) {
			int n = Integer.parseInt(line);
			if(n==0)break;
			sb.append(f( 0,n )+"\n");
		}
		System.out.print(new String(sb));
	}
	
	public static long f( int h, int w ){
		if(h>=0 && w < mem[h].length && mem[h][w]!=-1) return mem[h][w];
		if( w == 1 && h == 0 ) return mem[h][w]=1;
		if( h>=1 && w==0 ) return mem[h][w]=1;
		if( w < 0 || h < 0 ) return 0;
		else return mem[h][w]=f( h-1, w )+f( h+1, w-1 );
	}

}
