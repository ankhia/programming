

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Uva12577 {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int casos = 1;
		for (String linea; (linea = in.readLine())!=null; casos ++) {
			if(linea.charAt(0)=='*') break;
			if(linea.indexOf("Hajj")!=-1)
				System.out.println("Case "+casos+": Hajj-e-Akbar");
			else
				System.out.println("Case "+casos+": Hajj-e-Asghar"); 
		}
	}
}
