import java.io.*;
import java.util.*;


public class Acm5736 {

	static int m[][];
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String line; (line = in.readLine())!=null; ){
			StringTokenizer st = new StringTokenizer(line);
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			m = new int[r][c];
			for(int i = 0 ; i < m.length; i++){
				st = new StringTokenizer(in.readLine( ));
				for(int j = 0; j < m[i].length; j++){
					m[i][j]=Integer.parseInt(st.nextToken());
				}
			}
		}
			
		
	}

}
