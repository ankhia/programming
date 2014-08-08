

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Uva160 {

	static boolean criba[];
	static int prim[];
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		criba = new boolean[150];
		criba[0]=criba[1]=true;
		for (int i = 0; i < criba.length; i++) 
			if(!criba[i])
				for ( int j = 2*i; j < criba.length; j+=i ) 
					criba[j]=true;

		for (String linea; (linea=in.readLine())!=null;) {
			int a = Integer.parseInt(linea);

			if(a==0)break;
			sb.append(formatearATres(a)+"! =");

			prim = new int[101];
			for (int i = 1; i <= a; i++) {
				ArrayList<Long> misFac = descFacPrim(i);
				for (int j = 0; j < misFac.size(); j++) {
					long pos = misFac.get(j); 
					prim[(int) pos]++;
				}
			}

			for (int i = 0, j = 0; i <= a; i++) {
				if(!criba[i]){
					if(j<15){
						sb.append(formatearATres(prim[i]));
						j++;
					}
					else{
						sb.append("\n      "+formatearATres(prim[i]));
						j=0;
					}
				}
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}

	static String formatearATres( int n ){
		String nuevo = "";
		if(n<10)
			nuevo +="  "+n;
		else if ( n<100 ) 
			nuevo +=" "+n;
		else nuevo += n;
		return nuevo;
	}

	static ArrayList<Long> descFacPrim (long c){
		ArrayList<Long> f = new ArrayList<Long>();
		long n = c;
		while(n%2==0){
			n/=2;
			f.add(2l);
		}
		long i = 3l;
		while (i*i < n+1) {
			if( n%i == 0 ){
				f.add(i);
				n/=i;
			}else i += 2;
		}
		if(n>1)f.add(n);
		return f;
	}
}
