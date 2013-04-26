

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Uva499 {

	static HashMap<String, Integer> h ;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line; (line = in.readLine()) != null; ) {
			h = new HashMap<String, Integer>();
			for (int i = 0; i < line.length(); i++) {
				if(h.get(line.charAt(i)+"")==null && Character.isLetter(line.charAt(i))){
					h.put(line.charAt(i)+"", 1);
				}else if(Character.isLetter(line.charAt(i))){
					h.put(line.charAt(i)+"", h.get(line.charAt(i)+"")+1);
				}
			}
			
			int max = Integer.MIN_VALUE;
			for ( Iterator iter = h.entrySet().iterator(); iter.hasNext();) {
				Map.Entry e = (Map.Entry)iter.next();
				int act = (Integer) e.getValue( ); 
				if( act  > max )
					max = act;
//				System.out.println("Clave: " + e.getKey() + " | Valor: " + e.getValue());
			}
			
			ArrayList<String> a = new ArrayList<String>();
			for ( Iterator iter = h.entrySet().iterator(); iter.hasNext();) {
				Map.Entry e = (Map.Entry)iter.next();
				int act = (Integer) e.getValue( ); 
				if( act == max )
					a.add(e.getKey()+"");
			}
			
			Collections.sort(a);
			for (int i = 0; i < a.size(); i++) {
				sb.append(a.get(i));
			}
			sb.append(" "+max +"\n");
		}
		System.out.print(new String(sb));
	}
}
