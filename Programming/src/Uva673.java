

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Uva673 {

	static Stack<Character> p;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for (int i = 0; i < t; i++) {
			p = new Stack<Character>();
			String cadena = in.readLine();
			boolean fallo = false;
			for (int j = 0; j < cadena.length() && !fallo; j++) {
				if( cadena.charAt(j) == '(' || cadena.charAt(j) == '[' )
					p.add(cadena.charAt(j));
				else if( !p.isEmpty() && cadena.charAt(j) == ']' && p.peek() == '[' )
					p.pop();
				else if( !p.isEmpty() && cadena.charAt(j) == ')' && p.peek() == '(' )
					p.pop();
				else if(!p.isEmpty() && cadena.charAt(j) != p.peek())
					fallo = true;
				else if(p.isEmpty())
					fallo = true;
			}
			if(p.isEmpty() && !fallo)
				System.out.println("Yes");
			else 
				System.out.println("No");
		}
	}
}
