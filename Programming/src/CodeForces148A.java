import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CodeForces148A {
	
	static int punches[];
	static int d;
	static boolean hit[];
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln; (ln = in.readLine())!= null; ){
			punches = new int[4];
			punches[0] = Integer.parseInt(ln); 
			punches[1] = Integer.parseInt(in.readLine());
			punches[2] =  Integer.parseInt(in.readLine());
			punches[3] = Integer.parseInt(in.readLine());
			d = Integer.parseInt(in.readLine());
			hit = new boolean[d+1];
			System.out.println(count());
		}
	}
	
	static int count( ){
		if( punches[0] == 1 || punches[1] == 1 || punches[2] == 1 || punches[3] == 1 )
			return d;
		else {
			int cont = 0;
			for ( int i = 0; i < punches.length; i++ ) {
				for ( int j = punches[i]; j < hit.length; j+=punches[i] ) {
					if( !hit[j] ){
						cont++;
						hit[j] = true;
					}
				}
			}
			return cont;
		}
	}
}
