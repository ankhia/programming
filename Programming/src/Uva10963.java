import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva10963 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		int casos = Integer.parseInt(in.readLine());
		in.readLine();
		for (int i = 0; i < casos; i++) {
			int n = Integer.parseInt(in.readLine().trim());
			boolean can = true;
			int espacios = 0;
			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(in.readLine().trim());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if( j==0 ) espacios = a-b;
				else if( a-b != espacios ) can = false;
			}
			sb.append(can?"yes":"no").append("\n");
			if(i<casos-1){
				sb.append("\n");
				in.readLine();
			}
		}
		System.out.print(new String(sb));
	}
}
