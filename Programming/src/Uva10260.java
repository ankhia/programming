

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1201
 * @veredict Accepted 
 * @problemId 10260
 * @problemName  Soundex
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level easy
 * @date 13/11/2011
 **/

public class Uva10260 {

	static HashMap<String, Integer> hash ; 
	public static void main(String[] args) throws Throwable {
		hash = new HashMap<String, Integer>();
		hash.put("B", 1);
		hash.put("F", 1);
		hash.put("P", 1);
		hash.put("V", 1);
		hash.put("C", 2);
		hash.put("G", 2);
		hash.put("J", 2);
		hash.put("K", 2);
		hash.put("Q", 2);
		hash.put("S", 2);
		hash.put("X", 2);
		hash.put("Z", 2);
		hash.put("D", 3);
		hash.put("T", 3);
		hash.put("L", 4);
		hash.put("N", 5);
		hash.put("M", 5);
		hash.put("R", 6);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder nuevo = new StringBuilder();
		for (String line;(line = in.readLine())!=null ; ) {
			for (int i = 0; i < line.length(); i++) {
				if( i==0 && hash.get(line.charAt(i)+"")!=null ){
					nuevo.append(hash.get(line.charAt(i)+""));
				}else if( hash.get(line.charAt(i)+"")!=null && hash.get(line.charAt(i-1)+"")!=null){
					if(hash.get(line.charAt(i)+"")!=hash.get(line.charAt(i-1)+""))
						nuevo.append(hash.get(line.charAt(i)+""));
				}else if( hash.get(line.charAt(i)+"")!=null ){
					nuevo.append(hash.get(line.charAt(i)+""));
				}
			}
			nuevo.append("\n");
		}
		System.out.print(new String(nuevo));
	}

}
