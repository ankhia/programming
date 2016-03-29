import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CodeForces158B {

	static int v[];
	
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		v = new int[5];
		Arrays.fill(v, 0);
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			v[Integer.parseInt(st.nextToken())]++;
		}
		int count = v[4];	

		if( v[1] > 0 )
			v[1] = v[3]>v[1]?0:v[1]-v[3];
		
		count += v[3];
		int techo = (int) Math.ceil(v[2]/2.);
		int piso = (int) Math.floor(v[2]/2.);
		if( techo != piso ) v[1]-=2;
		count+=techo;
		
		int unos = v[1]>0?(int) Math.ceil(v[1]/4.):0;
		count+=unos;
		
		System.out.println(count);
	}
}
