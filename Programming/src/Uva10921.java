

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1862
 * @veredict  Accepted
 * @problemId 10921
 * @problemName Find the Telephone
 * @judge http://uva.onlinejudge.org/
 * @category Adhoc
 * @level easy
 * @date 25/12/2012
 **/
public class Uva10921 {

	static HashMap<String, Integer> h; 

	public static void main(String[] args) throws Throwable {
		h = new HashMap<String, Integer>();
		h.put("ABC", 2);
		h.put("DEF", 3);
		h.put("GHI", 4);
		h.put("JKL", 5);
		h.put("MNO", 6);
		h.put("PQRS", 7);
		h.put("TUV", 8);
		h.put("WXYZ", 9);

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line; (line = in.readLine())!=null; ) {
			for (int i = 0; i < line.length(); i++) {
				Iterator it = h.entrySet().iterator();
				boolean encontre = false;
				while (it.hasNext() && !encontre) {
					Map.Entry e = (Map.Entry)it.next();
					if((e.getKey()+"").contains(line.charAt(i)+"")){
						sb.append(e.getValue());
						encontre=true;
					}
				}
				if(!encontre) sb.append(line.charAt(i));
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}

}
