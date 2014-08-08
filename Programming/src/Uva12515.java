

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=3960
 * @veredict Accepted 
 * @problemId 12515
 * @problemName Movie Police
 * @judge http://uva.onlinejudge.org/
 * @category Ac
 * @level easy
 * @date 10/12/2012
 **/ 

public class Uva12515 {

	static String strings[];
	
	public static void main(String[] args) throws Throwable
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int m = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		strings = new String[m];
		for (int c = 0; c < m; c++) {
			strings[c] = in.readLine();
		}
		
		for (int k = 0; k < q; k++) {
			int indice = -1;
			int min = Integer.MAX_VALUE;
			String query = in.readLine();
			for (int i = 0; i < m; i++) {
				if(strings[i].length()>= query.length()){
//					System.out.println(strings[i]+" "+strings[i].length());
					for (int j = 0; (j+query.length())-1 < strings[i].length() ; j++) {
						int diff = 0;
//						System.out.println(j +" "+(j+query.length()-1));
						for (int l = 0; l < query.length(); l++) {
							if(query.charAt(l) != strings[i].charAt(j+l))
								diff+=1;
						}
						if(diff < min){
							min = diff;
							indice = (i+1);
						}
					}
						
				}
			}
			sb.append(indice+"\n");
		}
		System.out.print(new String(sb));
	}
}
 