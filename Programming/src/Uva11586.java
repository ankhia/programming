import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Uva11586 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder( );
		for (int i = 0; i < cases; i++) {
			String line = in.readLine();
			int M = 0;
			int F = 0;
			for (int j = 0; j < line.length(); j++) {
				char actual = line.charAt(j);
				if( Character.isLetter(actual) ){
					if( actual == 'M')
						M++;
					else if( actual == 'F')
						F++;
				}
			}
			if(M==F && M > 1 )sb.append("LOOP\n");
			else sb.append("NO LOOP\n");
		}
		System.out.print(new String(sb));
	}
}
