

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Angie Milena Vega Leon
 * @veredict Accepted 
 * @problemId 
 * @problemName  ls
 * @judge Boca
 * @category ls
 * @level Easy
 * @date 22/07/2012
 **/

public class ls {

	public static void main(String[] args) throws Throwable {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String patron; (patron=in.readLine())!=null; ) {
			int n = Integer.parseInt(in.readLine());
			for (int palabras = 0; palabras < n; palabras++) {
				String palabra = in.readLine().trim();
				String file = palabra;
				int ini = -1, fin = -1;
				String buscar = "";
				boolean match = true;
				for (int i = 0; i < patron.length() && match ; i++) {
					if(patron.charAt(i)!='*'){
						buscar+=patron.charAt(i);
						if(ini==-1) ini = i;
						fin = i;
					} else {
						int indexB = file.indexOf(buscar);
						if(ini == 0 && indexB != -1){
							if(indexB != 0){
//								System.out.println("index!=0");
								match = false;
							}
							else {
								if((indexB+buscar.length())<file.length())
									file=file.substring(indexB+buscar.length());
								else{
//									System.out.println("indexB+buscar.length())<file.length() (1)");
									match = false;
								}
							}
						} else if( indexB != -1 ){
							if((indexB+buscar.length())<file.length())
								file=file.substring(indexB+buscar.length());
							else{
//								System.out.println("indexB+buscar.length())<file.length() (2)");
								match = false;
							}
						} else { 	match = false; 
//						System.out.println("index = -1"); 
						}
						
						buscar = "";
						ini  = -1; fin = -1;
					}
				}
				
				if(buscar.length()>0){
					for (int i = buscar.length()-1 , j = palabra.length()-1; i >= 0 && j >= 0 ; i--, j--) {
						if(buscar.charAt(i)!=palabra.charAt(j)){
//							System.out.println("final");
							match = false;
						}
					}
				}

				if(match)
					sb.append(palabra+"\n");
			}
		}
		System.out.print(new String(sb));
	}
}
