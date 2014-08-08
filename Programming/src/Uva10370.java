

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.StringTokenizer;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1311
 * @veredict Accepted 
 * @problemId 10370
 * @problemName  Above Average
 * @judge http://uva.onlinejudge.org/
 * @category AdHoc
 * @level easy
 * @date 26/03/2011
 **/ 

public class Uva10370 {

	public static void main(String[] args) throws Throwable {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(bf.readLine());
		for (int i = 0; i < casos; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int alumnos[] = new int[n];
			double promedio = 0;
			for (int j = 0; j < alumnos.length; j++) {
				alumnos[j] = Integer.parseInt(st.nextToken());
				promedio+=alumnos[j];
			}
			promedio/=n;
			int cantEst = 0;
			for (int j = 0; j < alumnos.length; j++) {
				if( alumnos[j] > promedio )
					cantEst++;
			}
			DecimalFormatSymbols s = new DecimalFormatSymbols();
			s.setDecimalSeparator('.');
			DecimalFormat df = new DecimalFormat("#0.000",s);
			System.out.println(df.format((double)(cantEst*100)/n)+"%");
		}
	}
}
