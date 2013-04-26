

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1012
 * @veredict Accepted 
 * @problemId 10071
 * @problemName Back to High School Physics
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level easy
 * @date 21/12/2011
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Uva10071 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		while((linea=bf.readLine())!=null){
			int v = Integer.parseInt(linea.split(" ")[0]);
			int t = Integer.parseInt(linea.split(" ")[1]);
			System.out.println((2*t)*v);
		}
	}
}
