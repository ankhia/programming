import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Uva10919 {

	static TreeSet<String> cour ;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		for(String line; (line =in.readLine() ) !=null;){
			if(line.trim().equals("0")) break;
			StringTokenizer st = new StringTokenizer(line);
			cour = new TreeSet<String>();
			int k = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			for (int courses = 0; courses < k; courses++) {
				if( !st.hasMoreTokens() )
					st = new StringTokenizer(in.readLine());
				cour.add(st.nextToken());
			}
			boolean can = true;
			
			for (int courses = 0; courses < m; courses++) {
				st = new StringTokenizer(in.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int cant = 0;
				for( int i = 0; i < c ; i++ ){
					String name = st.nextToken( );
					if( cour.contains(name))
						cant++;
				}
				if( cant < r )
					can = false;
			}
			
			if(can) sb.append("yes");
			else sb.append("no");
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
