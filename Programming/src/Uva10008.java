

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=949
 * @veredict Accepted 
 * @problemId 10008
 * @problemName  What's Cryptanalysis?
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level easy
 * @date 16/04/2012
 **/ 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Uva10008 {

	public static void main(String[] args) throws Throwable {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> letras = new HashMap<String, Integer>();
		int lineas = Integer.parseInt(bf.readLine());
		for (int i = 0; i < lineas; i++) {
			String in = bf.readLine();
			for (int j = 0; j < in.length(); j++) {
				char a = in.charAt(j);
				if(  Character.isLetter(a) ){
					String letrita = (in.charAt(j)+"").toUpperCase();
					if(letras.get(letrita) != null)
						letras.put(letrita, letras.get(letrita)+1);
					else
						letras.put(letrita, 1);
				}
			}
		}
		
		Map<String, Integer> mapOrdenado = new TreeMap<String, Integer>(letras);
		Set<String> claves = mapOrdenado.keySet();
		TreeSet<Integer> numeros = new TreeSet<Integer>(mapOrdenado.values());
		StringBuilder sb = new StringBuilder();
		for (Iterator<Integer> it = numeros.descendingIterator(); it.hasNext();) {
			int valor = it.next();
			for(String j : claves ){
				if(mapOrdenado.get(j) == valor){
					sb.append(j +" "+mapOrdenado.get(j)+"\n");
				}
			}
		}
		System.out.print(sb);
	}
}
