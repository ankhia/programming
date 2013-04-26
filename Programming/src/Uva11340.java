import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

public class Uva11340 {
	static double[] ch;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		int t = Integer.parseInt(in.readLine( ));
		ch = new double[300];
		for (int cases = 0; cases < t; cases++) {
			int canCh = Integer.parseInt(in.readLine());
			Arrays.fill(ch, 0);
			for (int letras = 0; letras < canCh; letras++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				String letra = st.nextToken();
				double cent = Integer.parseInt(st.nextToken());
				ch[(int)letra.charAt(0)] = cent/100.;
			}
			int canLin = Integer.parseInt(in.readLine());
			double suma = 0;
			for (int i = 0; i < canLin; i++) {
				char car = (char)in.read();
				while( car != '\n'){
					int carac = (int)car; 
//					if( carac >=0 && carac< ch.length )
						suma += ch[carac];
					car = (char)in.read();
				}
			}
			sb.append(String.format(Locale.US,"%.2f$", suma)+"\n");
		}
		System.out.print(new String(sb));
	}
}
