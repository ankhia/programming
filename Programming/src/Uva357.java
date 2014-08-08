

import java.io.*;
import java.util.*;

public class Uva357 {

	static int mon[] = new int[]{1,5,10,25,50};
	static long ways[];
	public static void main(String[] args) throws Throwable {
		Scanner in = new Scanner(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ways = new long[30001];
		llenar();
		for ( ; (in.hasNext()) ; ) {
			int n = in.nextInt();
			if( ways[n]>1 )
				sb.append("There are "+ways[n]+" ways to produce "+n+" cents change.\n");
			else
				sb.append("There is only 1 way to produce "+n+" cents change.\n");
		}
		System.out.print(new String(sb));
	}

	/**
	 * Forma Hippie
	 * Se llena hippiescamente
	 * Cada posicion del vector es un valor. Por cada valor alcanzable, intento alcanzar otro, con mas monedas.
	 * El valor en cada posicion del vector sera las formas totales para ese valor con esas monedas.
	 * Para calcular las formas sera: el valor de formas que tengo en mi pos actual i, mas el valor de formas de 
	 * la pos a la que ire, con la moneda en k
	 */
	private static void llenar() {
		ways[0]=1;
		for (int k = 0; k < mon.length; k++) {
			for (int i = 0; i < ways.length; i++) {
				if(i+mon[k]<ways.length)
					ways[i+mon[k]]+=ways[i];
			}
		}
	}	

	/**
	 * Forma recursiva 
	 * @param n Valor a Calcular
	 * @param i Posicion de la moneda
	 * @return Cantidad de formas en que se pueden dar monedas para dar el valor a calcular
	 */
	public static int f( int n , int i ){
		if( n==0 ) return 1;
		else if(n<0)return 0;
		else if( i<mon.length ) return f( n-mon[i], i ) + f(n, i+1);
		else return 0;
	}
}

