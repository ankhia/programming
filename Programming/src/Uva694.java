import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva694 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		for (String line ; (line = in.readLine()) != null ; tc++) {
			StringTokenizer st = new StringTokenizer(line);
			int A = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			if(A==-1&&L==-1)break;
			sb.append("Case "+tc+": A = "+A+", limit = "+L+", number of terms = ");
			long v = A;
			int cont = 1;
			while( v!=1 && v<=L ){
				if(v%2==0) v/=2;
				else  v = 3 * v + 1;
				if(v<=L)
				cont++;
			}
			sb.append(cont+"\n");
		}
		System.out.print(new String(sb));
	}

}
