import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva11677 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String ln; (ln = in.readLine())!=null; ) {
			StringTokenizer st = new StringTokenizer(ln);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if(a==0&&b==0&&c==0&&d==0)break;
			int sum = 0;
			if( a == c && d >= b ){
				sum += d-b;
			}else {
				sum += d;
				sum += 60 - b;
				a++;
				if( a<=c )
					sum+=(c-a)*60;
				else
					sum+= ((24-a)+c)*60;
			}
			sb.append(sum).append("\n");
		}
		System.out.print(new String(sb));
	}
	
}
