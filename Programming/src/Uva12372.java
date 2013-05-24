import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva12372 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		for (int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int l = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			if( (l <= 20 && w <= 20 && h <= 20)  )
				System.out.println( "Case "+(t+1)+": good");
			else
				System.out.println( "Case "+(t+1)+": bad");
		}
	}

}
