import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva10465 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(String ln;(ln=in.readLine())!=null;){
			StringTokenizer st = new StringTokenizer(ln); 
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			int max = Integer.MIN_VALUE;
			int beer = Integer.MAX_VALUE;
			for (int i = 0;   ; i++) {
				int x = (t - ( n*i )) / m; 
				int r = (t - ( n*i )) % m;
				if( r == beer){
					if( (x+i) > max ){
						max = x+i;
						beer = r;
					}
				}else if( r >= 0 && r < beer ){
					max = x+i;
					beer = r;
				}
				if( x == 0 ){
					break;
				}
			}
			for (int i = 0; ; i++) {
				int y = (t - ( m*i )) / n; 
				int r = (t - ( m*i )) % n;
				if( r == beer){
					if( (y+i) > max ){
						max = y+i;
						beer = r;
					}
				}else if( r >= 0 &&  r < beer ){
					max = y+i;
					beer = r;
				}
				if( y == 0 ) {
					break;
				}
			}
			sb.append(beer==0? max:max+" "+beer).append("\n");
		}
		System.out.print(new String(sb));
	}
}

