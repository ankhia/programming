

import java.io.*;
import java.util.*;

public class Acm3468 {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n;
		while( (n=Integer.parseInt(in.readLine())) != 0 ){
			int[ ] posts = new int [ n ];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < posts.length; i++) {
				posts[i]=Integer.parseInt(st.nextToken());
			}
			boolean termine = false;
			int sumaTotal = 0, a = 0, b=posts.length-1, cantidadCerosInicial=0, otros=0;
			for (int i = 0; i < posts.length; i++){ 
				if(posts[i]==0)	cantidadCerosInicial++;
				else { a=i; break;}
			}
			if(cantidadCerosInicial==posts.length){
				sumaTotal += Math.ceil(cantidadCerosInicial/2.);
				termine=true;
			}

			if(!termine){
				for (int i = posts.length-1; i >= 0 ; i--){
					if( posts[i]==0 )
						cantidadCerosInicial++;
					else { b=i; break;}
				}
				sumaTotal+=cantidadCerosInicial/2.;
				for (int i = a; i <= b ; i++) {
					if(posts[i]==0) otros++;
					else { /*System.out.println("aa " +otros);*/ sumaTotal += otros/2; otros = 0;}
				}
				sumaTotal += Math.ceil(otros/2.);
			}
			System.out.println(sumaTotal);
		}
	}
}
