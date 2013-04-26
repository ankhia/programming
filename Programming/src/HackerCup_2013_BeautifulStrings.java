

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HackerCup_2013_BeautifulStrings {

	
	static int letras [] ;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x = Integer.parseInt(in.readLine());
		for (int t = 0; t < x; t++) {
			String line = in.readLine();
			letras = new int[26];
			for (int i = 0; i < line.length(); i++) {
				if(Character.isLetter(line.charAt(i)))
				letras[(int)(Character.toUpperCase(line.charAt(i))-'A')] += 1;
			}
			long suma = 0;			
			int a = 26;
			Arrays.sort(letras);
			for (int i = letras.length-1; i >= 0; i--,a--) {
				if(letras[i]!=0)
					suma+=a*letras[i];
			}
			sb.append("Case #"+(t+1)+": "+suma+"\n");
		}
		System.out.print(new String(sb));
	}
}
