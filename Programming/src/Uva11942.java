
/**
 * Ejercicio de una Maraton toca buscarlo
 * http://uva.onlinejudge.org/external/119/11942.html
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Uva11942 {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int casos=Integer.parseInt(in.readLine());
		StringBuilder  sb = new StringBuilder();
		sb.append("Lumberjacks:\n");
		for (int i = 0; i < casos; i++) {
			String[] cosa = in.readLine().split(" ");
			boolean ordenados = true;
			for (int j = 0; j < cosa.length && ordenados; j++) {
				if( (j+1) < cosa.length )
					if( Integer.parseInt(cosa[j]) > Integer.parseInt(cosa[j+1]) )
						ordenados = false;
			}
			boolean ordenadosPalOtro = true;
			for (int j = cosa.length-1; j > 0 && ordenadosPalOtro; j--) {
				if( (j-1) >= 0 )
					if( Integer.parseInt(cosa[j]) > Integer.parseInt(cosa[j-1]) )
						ordenadosPalOtro = false;
			}
			if(ordenados || ordenadosPalOtro)sb.append("Ordered\n");
			else sb.append("Unordered\n") ;
		}
		System.out.print(new String(sb));
		
	}
}
