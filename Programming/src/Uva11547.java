

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Uva11547 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(in.readLine());
		for (int cas = 0; cas < casos; cas++) {
			int n =  Integer.parseInt(in.readLine());
			int total = (((((n*567)/9)+7492)*235)/47)-498;
			String a = total+"";
			System.out.println(total);
			System.out.println(a.charAt(a.length()-2));
		}
	}

}
