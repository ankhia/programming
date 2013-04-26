

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&category=24&problem=1023&mosmsg=Submission+received+with+ID+9855132
 * @veredict -- 
 * @problemId 136
 * @problemName  WERTYU
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level easy
 * @date 13/03/2012
 **/ 

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Uva10082 {
	static String[] a = new String[]{"`1234567890-=","QWERTYUIOP[]\\","ASDFGHJKL;\'","ZXCVBNM,./"};
	public static void main(String[] args) throws Throwable {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		while((linea=bf.readLine())!=null){
			String b[] = linea.split(" "); 
			StringBuilder sb = new StringBuilder();			
			for (int i = 0; i < b.length; i++) {
				for (int j = 0; j < b[i].length(); j++) {
					int[]k = darIndice(b[i].charAt(j));
					sb.append(a[k[0]].charAt(k[1]-1));
				}
				if(i+1<b.length)
					sb.append(" ");
			}			
			System.out.println(sb);
		}		
	}
	public static int[] darIndice(char c) {
		int[] ind = new int[2];
		boolean termine = false;
		for (int i = 0; i < a.length && !termine; i++) {
			for (int j = 0; j < a[i].length() && !termine; j++) {
				if( a[i].charAt(j) == c ){
					ind[0]=i;
					ind[1]=j;
					termine = true;
				}
			}
		}
		return ind;
	}
}
