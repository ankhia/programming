import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CodeForces58A {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		for(String ln ; (ln = in.readLine())!=null; ){
			int indexOfH = ln.indexOf('h');
			int indexOfE = ln.indexOf('e', indexOfH+1 );
			int indexOfL = ln.indexOf('l', indexOfE+1 );
			int indexOfL2 = ln.indexOf('l', indexOfL+1);
			int indexOfO = ln.indexOf('o', indexOfL2+1 );
			if( indexOfH!= -1 && indexOfH < indexOfE && indexOfE < indexOfL && indexOfL < indexOfL2 && indexOfL2 < indexOfO ) {
				System.out.println("YES");
			}
			else System.out.println("NO");
		}
	}
}
