

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sweets {


	static String m[];

	public static void main(String[] args) throws Throwable {


		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
		int casitos = Integer.parseInt(in.readLine());
		for (int casos = 0; casos < casitos; casos++) {
			in.readLine();
			StringTokenizer st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			m = new String[r];
			for (int j = 0; j < r; j++) {
				m[j] = in.readLine();
			}

			int cantDulces = 0;
			int dulce =0;
			for (int i = 0; i < m.length; i++) {
				dulce = 0;
				for (int j = 0; j < m[0].length(); j++) {
					if(m[i].charAt(j)==((char)62) )
						dulce = 1;
					else if( dulce == 1 && m[i].charAt(j)==((char)111)) 
						dulce = 2;
					else if(dulce==2 && m[i].charAt(j)==((char)60) ){
						cantDulces++;
						dulce = 0;
					}else
						dulce = 0;
				}
			}
			dulce = 0;
			for (int i = 0; i < m[0].length(); i++) {
				dulce = 0;
				for (int j = 0; j < m.length; j++) {
					if(m[j].charAt(i)==((char)118) )
						dulce = 1;
					else if( dulce == 1 && m[j].charAt(i)==((char)111) ) 
						dulce = 2;
					else if(dulce == 2 && m[j].charAt(i)==((char)94)){
						cantDulces++;
						dulce = 0;
					}else
						dulce = 0;
				}
			}

			System.out.println(cantDulces);
		}
	}
}
