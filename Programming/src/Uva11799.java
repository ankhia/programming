import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva11799 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
		int tc = Integer.parseInt(in.readLine());
		for (int t = 0; t < tc; t++) {
			int max = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(in.readLine());
			int cant = Integer.parseInt(st.nextToken());
			while(cant-->0){
				int act = Integer.parseInt(st.nextToken()); 
				if( act > max)
					max = act;
			}
			System.out.println("Case "+(t+1)+": "+max);
		}
	}
}


