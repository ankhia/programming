

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&category=24&problem=1241&mosmsg=Submission+received+with+ID+9767625
 * @veredict Accepted 
 * @problemId 10300
 * @problemName  Ecological Premium
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level easy
 * @date 12/11/2011
 **/ 

public class Uva10300 {

	static int f;
	static int a;
	static int e;
	static int suma;
	
	public static void main(String[] args) throws Throwable{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(bf.readLine());
		for (int i = 0; i < casos; i++) {
			suma = 0;
			int granjeros = Integer.parseInt(bf.readLine());
			for (int j = 0; j < granjeros; j++) {
				String linea = bf.readLine();
				StringTokenizer st = new StringTokenizer(linea);
				int f = Integer.parseInt(st.nextToken());
				st.nextToken();
				int e= Integer.parseInt(st.nextToken());
				double uno = f * e;
				suma += uno;
			}
			System.out.println(suma);
		}
	}
}
