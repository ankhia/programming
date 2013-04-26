

import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.Integer.*;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&category=24&problem=1361&mosmsg=Submission+received+with+ID+11068597
 * @veredict Accepted 
 * @problemId 10420
 * @problemName List of Conquests
 * @judge http://uva.onlinejudge.org/
 * @category AdHoc
 * @level easy
 * @date 24/12/2012
 **/
public class Uva10420 {

	static TreeMap<String, Integer> h ;
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int lines = parseInt(in.readLine());
		h = new TreeMap<String, Integer>();
		for(int c = 0; c < lines; c++){
			String words[] = in.readLine().split(" "); 
			if(h.get(words[0])==null)
				h.put(words[0], 1);
			else
				h.put(words[0], h.get(words[0])+1);
		}
		StringBuilder sb = new StringBuilder();
		Iterator it = h.entrySet().iterator();
		while (it.hasNext()) {
		Map.Entry e = (Map.Entry)it.next();
			sb.append(e.getKey() + " " + e.getValue()+"\n");
		}
		System.out.print(new String(sb));
	}
}
