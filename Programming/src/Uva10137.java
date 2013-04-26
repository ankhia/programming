

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=29&page=show_problem&problem=1078
 * @veredict Accepted 
 * @problemId 10189
 * @problemName  The Trip
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level easy
 * @date 14/11/2011
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Uva10137 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(bf.readLine());
		while( casos != 0 ){

			double []n = new double[casos];
			double suma = 0;
			double finPos = 0;
			double finNeg = 0;
			
			for(int i = 0 ; i < casos ; ++i ){
				n[i]=Double.parseDouble(bf.readLine());
				suma+=n[i];
			}

			double demas = suma/casos;
			for(int i = 0; i < casos; i++ ){
				float diferencia = (float)( (long) ((n[i] - demas) * 100.0) / 100.0 );
				if( diferencia < 0 )
					finNeg+=diferencia;
				else
					finPos+=diferencia;
			}
			double cambio = ( Math.abs(finNeg) > finPos ) ? Math.abs(finNeg):finPos;
			System.out.printf("$%.2f",cambio);
			System.out.println();
			casos = Integer.parseInt(bf.readLine());
		}
	}
}
