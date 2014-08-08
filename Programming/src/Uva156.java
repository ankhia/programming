/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&category=24&problem=92&mosmsg=Submission+received+with+ID+14005376
 * @veredict Accepted 
 * @problemId 156
 * @problemName  Ananagrams
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level Ad hoc
 * @date 07/08/2014
 **/ 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class Uva156 {
	static TreeMap<String, ArrayList<String>> count;
	static TreeSet<String> words;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		count = new TreeMap<String, ArrayList<String>>();
		words = new TreeSet<String>();
		for(String line; (line = in.readLine())!=null; ){
			if( line.equals("#") ) break;
			StringTokenizer st = new StringTokenizer(line);
			while(st.hasMoreTokens()) {
				String word = st.nextToken( );
				char[] inOrder = word.toLowerCase().toCharArray();
				Arrays.sort(inOrder);
				String inOrderString = new String(inOrder);
				if( count.containsKey(inOrderString) ){
					ArrayList<String> a = count.get(inOrderString);
					a.add(word);
					count.put(inOrderString, a);
				}
				else {
					ArrayList<String> a = new ArrayList<String>();
					a.add(word);
					count.put(inOrderString, a);
				}
			}
		}
		for ( String key : count.keySet() ) 
			if( count.get(key).size() == 1 )
				words.add(count.get(key).get(0));
		for(String key : words)
			sb.append(key).append("\n");
		System.out.print(new String(sb));
	}
}
