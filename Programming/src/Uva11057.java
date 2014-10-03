import java.io.*;
import java.util.*;

public class Uva11057 {

	static int[] books;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String ln ; (ln = in.readLine())!=null; ) {
			int N = Integer.parseInt(ln);
			books = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				books[i]=Integer.parseInt(st.nextToken());
			}
			int money = Integer.parseInt(in.readLine());
			Arrays.sort(books);
			int minDiff = Integer.MAX_VALUE;
			int first = -1;
			int last  = -1;
			for (int i = 0; i < books.length; i++) {
				for (int j = i+1; j < books.length; j++) {
					if(books[i]+books[j]==money && Math.abs(books[i] - books[j]) < minDiff ){
						minDiff = Math.abs(books[i] - books[j]);
						first = i;
						last = j;
					}
				}
			}
			sb.append("Peter should buy books whose prices are "+books[first]+" and "+books[last]+".\n");
			in.readLine( );
			sb.append("\n");
		}
		System.out.print(new String(new String(sb)));
	}
}
