

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=submit_problem&problemid=532&category=24
 * @veredict -- 
 * @problemId 591
 * @problemName  --
 * @judge http://uva.onlinejudge.org/
 * @category Greedy
 * @level easy
 * @date 15/03/2012
 **/ 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva591 {

	public static void main(String[] args) throws Throwable {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int vienen = Integer.parseInt(bf.readLine());
		int cont = 1;
		while( vienen != 0 ){
			int[] numeros = new int [vienen];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int suma = 0;
			for (int i = 0; i < numeros.length; i++) {
				numeros[i] = Integer.parseInt(st.nextToken());
				suma+=numeros[i];
			}
			int div = suma / vienen;
			int minimo = 0;
			for (int i = 0; i < numeros.length; i++) {
				int a =  numeros[i]-div;
				if( a > 0 )
					minimo+=a;
			}
			System.out.println("Set #"+cont);
			System.out.println("The minimum number of moves is "+minimo+".");
			System.out.println();
			vienen = Integer.parseInt(bf.readLine());
			cont ++;
		}
	}
}
