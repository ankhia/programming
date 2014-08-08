import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CF344A {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int cont = 1;
		char ant = '*';
		for (int i = 0; i < n; i++) {
			String line = in.readLine();
			System.out.println( line );
			char p = line.charAt(0);
			char s = line.charAt(1);
//			System.out.println( ant+" "+p);
			if(i==0){ System.out.println("aaa"); ant = s; }
			else if( ant == p ) cont++;
		}
		System.out.println(cont);
	}

}
