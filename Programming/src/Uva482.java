import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva482 {

	static int[] numeros ;
	static String[] permutacion ;
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		int cases = Integer.parseInt(in.readLine());
		for (int i = 0; i < cases; i++) {
			in.readLine( );
			StringTokenizer st = new StringTokenizer(in.readLine());
			numeros = new int[st.countTokens( )];
			for (int j = 0; j < numeros.length; j++) {
				numeros[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine( ));
			permutacion = new String[st.countTokens()];
			for (int j = 0; j < permutacion.length; j++) {
				permutacion[j] = st.nextToken( );
			}
			String nuevaPer[] = new String[numeros.length];
			for (int j = 0; j < numeros.length; j++) {
				nuevaPer[numeros[j]-1] = permutacion[j];
			}
			for (int j = 0; j < nuevaPer.length; j++) {
				sb.append(nuevaPer[j]+"\n");
			}
			if( i < cases -1 )
				sb.append("\n");
		}
		System.out.print(new String(sb));
	}

}
