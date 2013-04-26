

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=235
 * @veredict Accepted 
 * @problemId 299
 * @problemName  Train Swapping
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level easy
 * @date 13/03/2012
 **/ 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva299 {

	public static void main(String[] args) throws Throwable {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(bf.readLine());
		for (int i = 0; i < casos; i++) {
			int cantNumeros = Integer.parseInt(bf.readLine());
			int[] numeros = new int[ cantNumeros ];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < cantNumeros; j++) {
				numeros[j]=Integer.parseInt(st.nextToken());
			}
			int cont = 0;
			int[] copia = numeros.clone();
			Arrays.sort(copia);
			
			while( estaDesordenado( numeros,copia ) ){
				boolean a1 = true;
				for (int j = 1; j < cantNumeros && a1 ; j++) {
					if( numeros[j-1] > numeros[j] ){
						numeros[j-1]^=numeros[j];
						numeros[j]^=numeros[j-1];
						numeros[j-1]^=numeros[j];
						cont++;
						a1=false;
					}
				}
				for (int j = 0; j < copia.length; j++) {
					
				}
			}
			System.out.println("Optimal train swapping takes "+cont+" swaps.");
		}
	}

	private static boolean estaDesordenado(int[] numeros, int[] copia) {
		for (int i = 0; i < numeros.length; i++) {
			if(numeros[i]!=copia[i])
				return true;
		}
		return false;
	}
	
}
