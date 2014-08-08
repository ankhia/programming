import java.io.*;
import java.util.*;


/**
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1326
 * Uva 10385
 * Duathlon
 * @author Milena
 */
public class BusquedaTernaria {

	static double rv[];
	static double cv[];
	static int t;
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String line; (line = in.readLine())!=null; ) {
			if(!line.trim().equals("")){
				t = Integer.parseInt(line);
				int n = Integer.parseInt(in.readLine());
				rv = new double[n];
				cv = new double[n];
				
				for (int i = 0; i < n; i++) {
					StringTokenizer st = new StringTokenizer(in.readLine());
					rv[i] = Double.parseDouble(st.nextToken());
					cv[i] = Double.parseDouble(st.nextToken());
				}
				solve( );
			}
		}
	}
	private static void solve() {
		//puntos terciarios
		double a = 0;
		double b = t;
		while( b - a >= 1e-4 ){
			double aTemp = a +( b - a )/3;
			double bTemp = a +2*( b - a )/3;
			double valorA = mejorTiempo(aTemp) - miTiempo(aTemp);
			double valorB = mejorTiempo(bTemp) - miTiempo(bTemp);
			
			if(valorA < valorB ) a = aTemp ;
			else if(  valorA > valorB )	b = bTemp;
			else{
				a = aTemp;
				b = bTemp;
			}
		}
		// cuando termine el ciclo se que encontre el optimo y valido el punto
		// como a es muy parecido a b puedo tomar cualquiera de los dos
		double tiempoGanar =  ( mejorTiempo( a ) - miTiempo( a ) ) * 3600;
		String r = String.format(Locale.US, "%.2f", a);
		String k = String.format(Locale.US, "%.2f", (t-a));
		String time = String.format(Locale.US, "%.0f", tiempoGanar);
		if( tiempoGanar >= 0)
			System.out.println("The cheater can win by "+time+" seconds with r = "+r+"km and k = "+k+"km.");
		else
			System.out.println("The cheater cannot win.");
	}
	
	private static double miTiempo( double p ){
		return ( p/rv[rv.length-1]) + ( (t-p) / cv[cv.length-1] );
	}
	
	private static double mejorTiempo( double p ){
		double mejor = Double.MAX_VALUE;
		for (int j = 0; j < rv.length-1; j++) {
			double temp = ( p/rv[j]) + ( (t-p) / cv[j] );
			if( temp < mejor )
				mejor = temp;
		}
		return mejor;
	}
}
