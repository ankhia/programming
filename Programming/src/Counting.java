

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Counting {

	/**
	 * @param args
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Throwable {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		while((linea=bf.readLine())!=null){
			int n = Integer.parseInt(linea);
			int cantidadDePermutaciones=0;
			ArrayList<Integer> numeros = new ArrayList<Integer>();
			int mayor=3;
			numeros.add(mayor);
			int sumita = 0;
			while( numeros.size() < n ){

				while( (sumita = sumaN(n, numeros)) < n ) {
					numeros.add(mayor);
					sumita = sumaN(n, numeros);
					if(sumita == n){
						cantidadDePermutaciones++;
						while (nextPermutation(numeros)) {
							cantidadDePermutaciones++;
						}
						int aDisminuir = numeros.get(numeros.size()-1);
						if(aDisminuir > 1){
							numeros.remove(numeros.size()-1);
							numeros.add(aDisminuir-1);
							mayor = aDisminuir;
						}
					}
					else if( sumita > n ){
						int aDisminuir = numeros.get(numeros.size()-1);
						if(aDisminuir > 1){
							numeros.remove(numeros.size()-1);
							numeros.add(aDisminuir-1);
						}
					}
				}
			}
		}
	}

	static int sumaN( int numero , ArrayList<Integer> numeros){
		int sume = 0;
		for (int i = 0; i < numeros.size(); i++) {
			if( numeros.get(i).equals(4) )
				sume+=1;
			else
				sume+=numeros.get(i);
		}
		return sume;
	}

	static boolean nextPermutation(List<Integer> a){

		int[]p = new int [a.size()];
		for (int i = 0; i < p.length; i++) {
			p[i]=a.get(i);
		}

		int k,l,aux,i,j;
		for (k = p.length-1; k>0 && p[k-1]>=p[k]; k--);
		if (k!=0){
			for (l = p.length-1; l>0 && p[k-1]>=p[l]; l--);
			aux=p[k-1]; p[k-1]=p[l]; p[l]=aux;
			for (i = k, j = p.length-1; i<j ; i++,j--){
				aux=p[i]; p[i]=p[j]; p[j]=aux;
			}
			return true;
		} 	
		else return false;
	}

}
