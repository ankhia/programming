

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=72
 * @veredict -- 
 * @problemId 136
 * @problemName  Ugly Numbers
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level easy
 * @date 13/03/2012
 **/ 


public class Uva136 {

	static TreeSet<Long> arbolito;
	static int cont;
	static int n;

	public static void main(String[] args) {
//		long i = 306110016;
//		cont = 1300;
//		n=1500;
//		while( cont < n ){
//			if( prime_factorization( i ) ){
//				cont++;
//				if(cont%100==0)
//					System.out.println(cont+" "+i);
//			}
//			if(cont == n)
//				System.out.println(i);
//			i++;
//		}
		arbolito = new TreeSet<Long>();
		System.out.println("a");
		solve();
		System.out.println(arbolito.size());

		for (Long a : arbolito) {
			System.out.println(a);
		}
		
		if(arbolito.size()==1501){
			System.out.println(arbolito.last());
		}
	}

	static void solve(){
		
		long a = 2;
		long b = 3;
		long c = 5;
		arbolito.add((long)1);
		arbolito.add(a);
		arbolito.add(b);
		arbolito.add(c);
		while(arbolito.size()<11){
			arbolito.add(a*2);
			arbolito.add(a*3);
			arbolito.add(a*5);
			b*=3;
			arbolito.add(b);
			b*=2;
			c*=5;
			
			
			arbolito.add(c);
		}
	}
	
//	static boolean prime_factorization(long x)
//	{
//		long i;
//		long c;
//		c = x;
//		boolean isUgly = false;
//		while ((c % 2) == 0) {
//			isUgly = true;
//			c = c / 2;
//		}
//		i = 3;
//		while (i <= (Math.sqrt(c)+1)) {
//			if ((c % i) == 0) {
//				if( i!=2 &&  i!=3 &&  i!=5 )
//					return false;
//				c = c / i;
//			}
//			else{
//				i = i + 2;
//			}
//		}
//		
//		if (c > 1 && ( c==2 ||  c==3 ||  c==5 )) return true;
//		else if(isUgly && c==1){ return true;}
//		return false;
//	}

}
