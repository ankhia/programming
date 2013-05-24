import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva12468 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String line ; (line = in.readLine())!=null; ) {
			StringTokenizer st = new StringTokenizer( line );
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			if( i == -1 && j == -1) break;
			int n = Integer.MAX_VALUE;
			
			int resta = Math.max(i, j) - Math.min(i, j ); 
			if( resta < n ) n = resta;
			
			int sum = 0;
			for (int k = Math.max(i, j); k != Math.min(i, j); k++) {
				if( k == 100 ) k = -1;
				else sum++;
			}
			if(sum < n) n = sum;
			System.out.println(n);
		}
	}

}
