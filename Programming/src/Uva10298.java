

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Uva10298 {
	static String linea;
	public static void main(String[] args) throws Throwable{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for ( ;!(linea = bf.readLine()).equals("."); ) {
			sb.append(solve());
			sb.append("\n");
		}
		System.out.println(new String(sb));
	}
	
	static int solve( ){
		for (int i = 0; i < linea.length(); i++) {
			
		}
		return 0;
	}
	
//	static int[] getBorderArray(char[] W) { 
//		 int[] T=new int[W.length+1]; T[0]=-1; T[1]=0; 
//		 for (int i=2,j=0; i<=W.length; )
//		 {if (W[i-1]==W[j]) T[i++]=++j; else if (j>0) j=T[j]; else T[i++]=0;} 
//		 return T; 
//	}
}


//public static boolean todasIguales( String linea){
//for (int i = 0; i < linea.length(); i++) {
//	if( (i+1)<linea.length() )
//		if( linea.charAt(i)!=linea.charAt(i+1) )
//			return false;
//}
//return true;
//}
//
//public static int solve(String linea){
//
//int max = MIN_VALUE;
//LinkedList<String> array;
//int tam = linea.length();
//for (int i = 1; i < tam ; i++) {
//	if(tam%i == 0){
//		array = new LinkedList<String>();
//		int pos = 0;
//		int p = i;
//		while( (pos+p)-1 < tam ){
//			array.add(linea.substring(pos, (pos+p)));
//			pos+=p;
//		}
//		if(todasIguales(array)){
//			if(tam/i>max) max = tam/i;
////			System.out.println(tam+" "+i+" "+max);
//		}
//	}
//}
//return max;
//}
//private static boolean todasIguales(List<String> array) {
//String compara = array.get(0);
////System.out.println(compara);
//for (String a : array) {
////	System.out.println(a);
//	if(!a.equals(compara)){
////		System.out.println("no hay igual una");
//		return false;
//	}
//		
//}
//return true;
//}