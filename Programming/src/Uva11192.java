

import java.io.*;
import java.util.*;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2133
 * @veredict Accepted 
 * @problemId 11192
 * @problemName Group Reverse
 * @judge http://uva.onlinejudge.org/
 * @category Math Ac
 * @level easy
 * @date 10/12/2012
 **/ 

public class Uva11192  {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line; (line=in.readLine())!=null;) {
			StringTokenizer st = new StringTokenizer(line);
			int cantGrupos = Integer.parseInt(st.nextToken());
			if(cantGrupos == 0) break;
			String cadena = st.nextToken();
			int cant = cadena.length()/cantGrupos;
			
			StringBuilder res = new StringBuilder();
			StringBuilder temp;
			for (int i = 0; i < cantGrupos; i++) {
				temp = new StringBuilder();
				int h = 0;
				for(int j = i*cant; h < cant && j < cadena.length(); j++,h++){
					temp.append(cadena.charAt(j));
				}
				temp = temp.reverse();
				res.append(temp);
			}
			sb.append(res+"\n");
		}
		System.out.print(new String(sb));
	}

}
