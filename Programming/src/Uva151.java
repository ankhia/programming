import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Uva151 {

	static boolean []off;
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
		for (String line; (line = in.readLine()) != null; ) {
			int n = Integer.parseInt(line);
			if(n == 0)break;
			off=new boolean[n];

			boolean termine = false;
			for (int j = 1; !termine; j++) {
				Arrays.fill(off, false);
				int total = 0;
				int m = j;
				int cpy = 0;
				int ultimoApagado=-1;
				for (int i = 0; total < n ; i++) {
					if(i >= n )
						i = 0;
					if( cpy == 0 && !off[i] ){
//						System.out.println(i+1);
						ultimoApagado = i+1;
						off[i] = true;
						cpy = m-1;
						total++;
					}else if(!off[i]){
						cpy--;
					}
				}
//				System.out.println("aaaaaaaaa " + total+ " "+ultimoApagado);
				if(ultimoApagado == 13){
					termine = true;
					System.out.println(m);
				}
			}
		}
	}
}
