

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MadNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] v = new char[]{'A','U','E','O','I'};
		char[] c = new char[]{'J','S','B','K','T','C','L','D','M','V','N','W','F','X','G','P','Y','H','Q','Z','R','S'};
		int casos = Integer.parseInt(bf.readLine());
		for (int i = 0; i < casos; i++) {
			int n = Integer.parseInt(bf.readLine());
			StringBuilder sb = new StringBuilder();
			char vocales[] = new char[(int) Math.ceil((double)n/2)];
			char sol[]=new char[n];
			char consonantes[] = new char [n/2];
			for (int j = 0; j < vocales.length; j++) {
				vocales[j]= vocales[j/21];
			}
			for (int j = 0; j < consonantes.length; j++) {
				vocales[j]= consonantes[j/5];
			}
			Arrays.sort(vocales);Arrays.sort(consonantes);
			int contVocales = 0;
			int posVocales=0;
			int contConsonantes = 0;
			int posConsonantes =0;
			for (int j = 0; j < n; j++) {
				if(j%2==0){
					sb.append(vocales[posVocales%vocales.length]);
					contVocales++;
					if(contVocales==25){
						posVocales++;
						contVocales=0;
					}
				}else{
					sb.append(consonantes[posConsonantes%consonantes.length]);
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
