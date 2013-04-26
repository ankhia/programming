

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class hero {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int batallas = Integer.parseInt(in.readLine());
		while(batallas!=0){
			int ganadas = batallas;
			for (int i = 0; i < batallas; i++) {	
				String linea = in.readLine().trim();
				if(linea.indexOf("CD") != -1)
					ganadas--;
			}
			System.out.println(ganadas);
			batallas = Integer.parseInt(in.readLine());
		}
	}
}
