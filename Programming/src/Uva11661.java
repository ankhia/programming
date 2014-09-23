import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Uva11661 {

	static int[] der;
	static int[] izq;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line ; (line = in.readLine())!=null; ) {
			int n = Integer.parseInt(line);
			if(n == 0) break;
			line = in.readLine();
			if( line.indexOf('Z') != -1 ){
				sb.append(0).append("\n");
			}else{
				der = new int[n];
				Arrays.fill(der, Integer.MAX_VALUE);
				int right = Integer.MAX_VALUE;
				boolean found = false;
				for (int i = 0; i < line.length(); i++){ 
					if( found )
						right++;
					der[i]=right;
					if(line.charAt(i) == 'D' ){
						right = 0;
						found = true;
						der[i]=right;
					}
				}
				
				izq = new int[n];
				found = false;
				int left = Integer.MAX_VALUE;
				for (int i = line.length()-1; i >= 0; i--) {
					if( found )
						left++;
					izq[i] = left;
					if( line.charAt(i) =='D' ){
						left = 0;
						found = true;
						izq[i] = left;
					}
				}
				
				int minimo = Integer.MAX_VALUE;
				for (int i = 0; i < n; i++) {
					if(line.charAt(i)=='R')
						minimo = Math.min(Math.min(izq[i], der[i]), minimo);
				}
				sb.append(minimo).append("\n");
			}
		}
		System.out.print(new String(sb));
	}
	
	
	
}

