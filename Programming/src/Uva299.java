

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

	//Mi antigua solucion
//	public static void main(String[] args) throws Throwable {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		int casos = Integer.parseInt(bf.readLine());
//		for (int i = 0; i < casos; i++) {
//			int cantNumeros = Integer.parseInt(bf.readLine());
//			int[] numeros = new int[ cantNumeros ];
//			StringTokenizer st = new StringTokenizer(bf.readLine());
//			for (int j = 0; j < cantNumeros; j++) {
//				numeros[j]=Integer.parseInt(st.nextToken());
//			}
//			int cont = 0;
//			int[] copia = numeros.clone();
//			Arrays.sort(copia);
//			
//			while( estaDesordenado( numeros,copia ) ){
//				boolean a1 = true;
//				for (int j = 1; j < cantNumeros && a1 ; j++) {
//					if( numeros[j-1] > numeros[j] ){
//						numeros[j-1]^=numeros[j];
//						numeros[j]^=numeros[j-1];
//						numeros[j-1]^=numeros[j];
//						cont++;
//						a1=false;
//					}
//				}
//				for (int j = 0; j < copia.length; j++) {
//					
//				}
//			}
//			System.out.println("Optimal train swapping takes "+cont+" swaps.");
//		}
//	}
//
//	private static boolean estaDesordenado(int[] numeros, int[] copia) {
//		for (int i = 0; i < numeros.length; i++) {
//			if(numeros[i]!=copia[i])
//				return true;
//		}
//		return false;
//	}
	
	//Solucion mergesort
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		int t = Integer.parseInt(in.readLine());
		for (int casos = 0; casos < t; casos++) {
			int n = Integer.parseInt(in.readLine());
			long v[] = new long[n];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < n; i++) {
				v[i] = Integer.parseInt(st.nextToken());   	
			} 
			numSwaps = 0;
			mergeSort(v, new long[v.length], 0, v.length-1);
			sb.append("Optimal train swapping takes "+numSwaps+" swaps.\n");
		}
		System.out.print(new String(sb));
	}

	static int numSwaps; //declarar numSwaps fuera del método e inicialice cuando corresponda
	static void mergeSort(long[] arr, long[] arrTmp, int pi, int pf) { 
		if (pf<=pi) return; 
		int m=(pi+pf)/2+1,i,j,k; mergeSort(arr,arrTmp,pi,m-1); mergeSort(arr,arrTmp,m,pf); 
		for (i=pi,j=m,k=pi; i<=m-1&&j<=pf; k++) {if (arr[i]<=arr[j]) arrTmp[k]=arr[i++]; else {numSwaps+=j-k; arrTmp[k]=arr[j++];}} 
		for (; i<=m-1; k++,i++) arrTmp[k]=arr[i]; 
		for (k=pi; k<j; k++) arr[k]=arrTmp[k]; 
	}
	
}
