

import java.io.*;
import java.util.*;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1895
 * @veredict Accepted 
 * @problemId 10954
 * @problemName  AddAll
 * @judge http://uva.onlinejudge.org/
 * @category DP
 * @level easy
 * @date 11/12/2012
 **/ 

public class Uva10954 {

	static PriorityQueue<Integer> lista ;
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String linea; (linea = in.readLine())!=null; ) {
			lista = new PriorityQueue<Integer>();
			int cant = Integer.parseInt(linea);
			if(cant == 0) break;
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < cant; i++) 
				lista.add(Integer.parseInt(st.nextToken()));

			int costo = 0;
			while( lista.size() > 1 ){
				int a = lista.poll();
				int b = lista.poll();
				int suma = a+b;
				lista.add(suma);
				costo+=suma;
			}
			sb.append(costo+"\n");
		}
		System.out.print(new String(sb));
	}
}
