

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1592
 * @veredict Accepted 
 * @problemId 10651
 * @problemName Pebble Solitaire
 * @judge http://uva.onlinejudge.org/
 * @category Ac
 * @level easy
 * @date 10/12/2012
 **/ 

public class Uva10651 {

	HashMap<String, Integer> mem = new HashMap<String, Integer>();
	static char BOLITA = 'o';
	static char PALITO = '-';
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int games = Integer.parseInt(in.readLine());
		for (int i = 0; i < games; i++) {
			String linea = in.readLine();
			char[] a = linea.toCharArray();
			System.out.println(f(a));

		}
	}

	public static int f( char a[] ){
		if(!hayMovimientos(a)){
//			System.out.println(Arrays.toString(a));
			int suma = 0;
			for (int i = 0; i < a.length; i++) {
				if(a[i]==BOLITA)
					suma+=1;
			}
			return suma;
		}else {
			//			int minimo = Integer.MAX_VALUE;
			int c = Integer.MAX_VALUE;
			for(int i = 0; i < a.length ; i++){
				if(a[i]==BOLITA){
					if( (i-1)>=0 && (i-2)>=0 && a[i-2]==PALITO && a[i-1]==BOLITA ){
						a[i-2]=BOLITA;
						a[i-1]=PALITO;
						a[i]=PALITO;
						int h = f(a);
						c = Math.min(c,h);
						a[i-2]=PALITO;
						a[i-1]=BOLITA;
						a[i]=BOLITA;
					} else if(  ( (i+1)<a.length && (i+2)<a.length && a[i+2]==PALITO && a[i+1]==BOLITA ) ){
						a[i+2]=BOLITA;
						a[i+1]=PALITO;
						a[i]=PALITO;
						int h = f(a);
						c = Math.min(c,h);
						a[i+2]=PALITO;
						a[i+1]=BOLITA;
						a[i]=BOLITA;
					}
				}
			}
			return c;
		}
	}

	public static boolean hayMovimientos( char[] a ){
		for (int i = 0; i < a.length; i++) {
			if(a[i]==BOLITA) {
				if( (i-1)>=0 && (i-2)>=0 && a[i-2]==PALITO && a[i-1]==BOLITA )
					return true;
				else if(  ( (i+1)<a.length && (i+2)<a.length && a[i+2]==PALITO && a[i+1]==BOLITA ) )
					return true;
			}
		}
		return false;
	}
}
