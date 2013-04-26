

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=996
 * @veredict Accepted 
 * @problemId 10055
 * @problemName Hashmat the Brave Warrior
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level easy
 * @date 21/12/2011
 **/ 

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Uva10055 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		while((linea=bf.readLine()) !=null ){
			long a = Long.parseLong(linea.split(" ")[0]);
			long b = Long.parseLong(linea.split(" ")[1]);
			System.out.println(Math.abs(a-b));
		}
	}
}
