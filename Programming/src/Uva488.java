

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Uva488 {
	
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		int casos = Integer.parseInt(in.readLine());
		in.readLine();
		for (int cas = 0; cas < casos; cas++) {
			int amp = Integer.parseInt(in.readLine());
			int fre = Integer.parseInt(in.readLine());
			in.readLine();
			for (int h = fre; h > 0; h--) {
				
				for (int i = 1; i <= amp; i++) {
					for (int j = 1; j <= i; j++) {
						sb.append(i);
					}
					sb.append("\n");
				}
				for (int i = amp-1; i > 0; i--) {
					for (int j = 1; j <= i; j++) {
						sb.append(i);
					}
					sb.append("\n");
				}
				sb.append(new String("\n"));
			}
		}
		sb = new StringBuilder(new String(sb.substring(0,sb.length()-2)));
		System.out.println(new String(sb));
	}
}
