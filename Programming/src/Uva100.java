

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=29&page=show_problem&problem=36
 * @veredict Accepted 
 * @problemId 100
 * @problemName  3n+1
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level easy
 * @date 12/11/2011
 **/ 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva100 {
	
	private static int v [];
	
	public static void main(String ... args) throws Exception{
		v = new int[1000000];
		v[0]=0;
		calcular();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		while( (linea=bf.readLine()) != null ){
			StringTokenizer st = new StringTokenizer(linea);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int mayor = Integer.MIN_VALUE;
			int res;
			if(a<b)
				 res = lala(a, b, mayor);
			else
				res = lala(b, a, mayor);
			System.out.println(a + " " + b + " " + res);
		}
	}
	
	public static int lala(int men, int may, int mayor){
		for(int i=men; i<=may; i++)
			if(v[i]>mayor) mayor = v[i];
		return mayor;
	}
	
	public static void calcular( ){
		for (int i = 1; i < v.length; i++) {
			int cont = 1;
			int j = i;
			while( j > 1 ){
				
				if( j%2 == 0 ){
					j/=2;cont++;
				}
				else{
					j=j*3+1;cont++;
				}
			}
			v[i]=cont;
		}
	}
}
