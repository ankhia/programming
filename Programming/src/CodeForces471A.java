import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CodeForces471A {

	static int [] n;
	static boolean [] usados;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = new int[ 6 ];
		for (int i = 0; i < 6; i++) {
			n[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(n);
//		System.out.println(Arrays.toString(n));
		boolean cabeza = false;
		boolean piernas = false;
		boolean cabeza2 = false;
		for (int i = 0; i < n.length; i++) {
//			System.out.println("-->"+i);
			int ig = 0;
			for (int j = i+1; j < n.length; j++) {
//				System.out.println(n[i]+" " +n[j]);
				if( n[i] == n[j] )
					ig++;
			}
//			System.out.println(n[i]+ " **  " + ig );
			if( ig >= 3 ) {
				piernas = true;
				i += 3;
			}
			else if( ig == 1 ) cabeza = true;
			else cabeza2 = true;
		}
		
		System.out.println((piernas&&cabeza) ?"Elephant":(piernas&&cabeza2)?"Bear":"Alien");
		
	}
}
