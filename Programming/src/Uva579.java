

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=520
 * @veredict -- 
 * @problemId 579
 * @problemName  ClockHands
 * @judge http://uva.onlinejudge.org/
 * @category --
 * @level --
 * @date 16/05/2012
 **/
public class Uva579 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String linea; !(linea=in.readLine()).equals("0:00");) {
			int hora = Integer.parseInt(linea.split(":")[0]);
			int minuto = Integer.parseInt(linea.split(":")[1]);
			//angulo minutero
			double alpha = minutosAGrados(minuto);
//			System.out.println("alpha min " +alpha);
			
			//angulo hora
			double beta = minutosAGrados(horasAMin(hora))+gradosDeMas(minuto);
//			System.out.println("minutosAGrados " + (double) minutosAGrados(horasAMin(hora)));
//			System.out.println("gradosDeMas "+(double)gradosDeMas(minuto));
//			System.out.println("beta hor "+beta);
			
			double anguloInterno = Math.abs(alpha - beta);
//			System.out.println("anguloInterno " +anguloInterno);
			
			double anguloExterno = 360-anguloInterno;
//			System.out.println("anguloExterno " +anguloExterno);
			
			double angulo = Math.min(anguloInterno, anguloExterno);
//			System.out.println("angulo " +angulo);
			DecimalFormatSymbols s = new DecimalFormatSymbols();
			s.setDecimalSeparator('.');
			DecimalFormat df = new DecimalFormat("#0.000",s);
			System.out.println(df.format(angulo));			
		}
		
	}
	public static int horasAMin( int hora ){
		if(hora == 12) hora = 0;
		return hora*5;
	}
	public static double minutosAGrados( int min ){
		return (min*180)/30;
	}
	public static double gradosDeMas( int min ){
		return (min*30)/60.0;
	}
}
