/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=562
 * @veredict Accepted 
 * @problemId 621
 * @problemName  Secret Research
 * @judge http://uva.onlinejudge.org/
 * @category Implementation , Java Strings
 * @level easy
 * @date 12/11/2011
 **/ 

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Uva621 {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			String s = in.readLine();
			if(s.endsWith("35")) System.out.println("-");
			else if( s.startsWith("9") && s.endsWith("4")) System.out.println("*");
			else if( s.startsWith("190") ) System.out.println("?");
			else System.out.println("+");
		}
	}
}
