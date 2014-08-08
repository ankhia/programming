

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=318
 * @veredict Accepted 
 * @problemId 382
 * @problemName Perfection
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level easy
 * @date 30/05/2012
 **/

public class Uva382 {
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("PERFECTION OUTPUT\n");
		String linea;
		boolean encontreCero = false;
		while(!encontreCero && (linea=in.readLine())!=null ){
			StringTokenizer st = new StringTokenizer(linea);
			while(st.hasMoreTokens()){
				int a = Integer.parseInt(st.nextToken());
				if(a==0){
					encontreCero = true;
					break;
				}

				if(a>=10000);
				else if(a>=1000)
					sb.append(" ");
				else if(a>=100)
					sb.append("  ");
				else if(a>=10)
					sb.append("   ");
				else
					sb.append("    ");

				if(a != 1){
				
				int suma = 1;
				for (int i = 2; i < a; i++) 
					if(a%i==0)
						suma += i;
				
				if(suma < a)
					sb.append(a+"  DEFICIENT\n");
				else if(suma > a)
					sb.append(a+"  ABUNDANT\n");
				else 
					sb.append(a+"  PERFECT\n");
				} else
					sb.append(a+"  DEFICIENT\n");
				
			}
		}
		
		sb.append("END OF OUTPUT\n");
		System.out.print(new String(sb));
	}

}
