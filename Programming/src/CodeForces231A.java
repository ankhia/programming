import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CodeForces231A {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int exercises = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int cont = 0;
			for (int j = 0; j < 3; j++) {
				int parseInt = Integer.parseInt(st.nextToken());
				if( parseInt == 1 )
					cont++;
			}
			if( cont > 1 )
				exercises++;
		}
		System.out.println(exercises);
	}

}
