

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2174
 * @veredict Accepted 
 * @problemId 11233
 * @problemName  Deli Deli
 * @judge http://uva.onlinejudge.org/
 * @category Stringology +/- AC
 * @level easy
 * @date 06/12/2012
 **/ 

public class Uva11233 {

	static HashMap<String, String> irregular ;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String linea; (linea=in.readLine())!=null;) {
			StringTokenizer st = new StringTokenizer(linea);
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			irregular = new HashMap<String, String>();
			for (int i = 0; i < r; i++) {
				linea = in.readLine();
				irregular.put(linea.split(" ")[0], linea.split(" ")[1]);
			}
			
			for (int i = 0; i < c; i++) {
				linea = in.readLine();
				if(irregular.get(linea)!=null)
					sb.append(irregular.get(linea)+"\n");
				else if(linea.lastIndexOf("y")==linea.length()-1 && isConsonant(linea.charAt(linea.length()-2)))
					sb.append(linea.substring(0, linea.length()-1)+"ies\n");
				else if( linea.lastIndexOf("o")== linea.length()-1 || linea.lastIndexOf("s")== linea.length()-1 || linea.lastIndexOf("ch")== linea.length()-2 
						|| linea.lastIndexOf("sh")== linea.length()-2 || linea.lastIndexOf("x")== linea.length()-1 ){
					sb.append(linea+"es\n");
				}else{
					sb.append(linea+"s\n");
				}
			}
		}
		System.out.print(new String(sb));
	}
	private static boolean isConsonant(char c) {
		if( c!='a' && c!='e' && c!='i' && c!='o' && c!='u' )
			return true;
		return false;
	}
}
