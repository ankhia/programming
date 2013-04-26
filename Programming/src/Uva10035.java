

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=976
 * @veredict Accepted 
 * @problemId 10035
 * @problemName  Primary Arithmetic
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level easy
 * @date 21/02/2012
 **/ 

public class Uva10035 {

	static int[]a;
	static int[]b;
	static int tam;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		while(!(linea=bf.readLine()).equals("0 0")){
			String[] numeros = linea.split(" ");
			tam = (numeros[0].length() > numeros[1].length()) ? numeros[0].length(): numeros[1].length();
			a=new int[tam];
			b=new int[tam];
			Arrays.fill(a, 0);
			Arrays.fill(b, 0);
			
			for (int i = (tam-1), j=numeros[0].length()-1; i >= 0 ; i--, j--) {
				if(j>=0)
					a[i]=Integer.parseInt(numeros[0].charAt(j)+"");
			}
			for (int i = (tam-1), j=numeros[1].length()-1; i >= 0 ; i--, j--) {
				if(j>=0)
					b[i]=Integer.parseInt(numeros[1].charAt(j)+"");
			}
			int carry = solve();
			if(carry == 0)
				System.out.println("No carry operation.");
			else if(carry == 1)
				System.out.println("1 carry operation.");
			else
				System.out.println(carry+ " carry operations.");
			
		}
	}
	
	static int solve( ){
		int carry=0;
		for(int i=tam-1;i>=0;--i){
			if(a[i]+b[i]>9){
				carry++;
				if((i-1)>=0)
					a[i-1]+=1;
			}
		}
		return carry;
	}
}
