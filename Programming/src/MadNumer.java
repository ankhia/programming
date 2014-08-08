

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MadNumer {


	public static void main(String[] args) throws Throwable {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] v = new char[]{'A','U','E','O','I'};
		char[] c = new char[]{'J','S','B','K','T','C','L','D','M','V','N','W','F','X','G','P','Y','H','Q','Z','R','S'};
		int casos = Integer.parseInt(bf.readLine());
		
		for (int i = 0; i < casos; i++) {
			int n = Integer.parseInt(bf.readLine());	
			StringBuilder sb = new StringBuilder();
			
			double cantLetras = Math.rint((double)n/10);
			if(n<10)
				cantLetras=1;
				
			char[] nuevo=new char[(int) cantLetras];
			for (int j = 0; j < (int)cantLetras; j++) {
				if(j<c.length)
					nuevo[j]=c[j];
			}
			Arrays.sort(nuevo);
			double cantVocales = Math.rint((double)n/25);
			if(n<25)
				cantVocales = 1;
			if((int)cantVocales > 5) cantVocales = 5;
			char nuevo2[] = new char[(int)cantVocales];
			for (int j = 0; j < nuevo2.length; j++) {
				if(j<v.length)
					nuevo2[j]=v[j];
			}
			Arrays.sort(nuevo2);
			
			int contVocales = 0;
			int posVocales=0;
			int contConsonantes = 0;
			int posConsonantes =0;
			for (int j = 0; j < n; j++) {
				if(j%2==0){
					sb.append(nuevo2[posVocales]);
					contVocales++;
					if(contVocales==25){
						posVocales++;
						contVocales=0;
					}
				}else{
					sb.append(nuevo[posConsonantes]);
					contConsonantes++;
					if(contConsonantes==5){
						posConsonantes++;
						contConsonantes=0;
					}
				}
			}
			System.out.println(sb);
		}
	}
}
