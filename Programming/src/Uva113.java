
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=49
 * @veredict Accepted 
 * @problemId 113
 * @problemName  Power of Cryptography
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level easy
 * @date 23/03/2011
 **/

public class Uva113 {
	public static void main(String[] args) throws Throwable {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		while( (linea = bf.readLine()) != null ){
			int n = Integer.parseInt(linea);
			double p = Double.parseDouble(bf.readLine());
			System.out.println((int)(Math.round(Math.pow(p, 1./n))));
		}
	}
}
