import java.io.*;
import java.lang.*;
import java.util.HashMap;

import static java.lang.Integer.*;
import static java.lang.Math.*;

public class Uva401 {

	static HashMap<Character, Character> h;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		h = new HashMap<Character, Character>();
		h.put('A', 'A');
		h.put('3', 'E');
		h.put('H', 'H');
		h.put('I', 'I');
		h.put('L', 'J');
		h.put('J', 'L');
		h.put('M', 'M');
		h.put('O', 'O');
		h.put('2', 'S');
		h.put('T', 'T');
		h.put('U', 'U');
		h.put('V', 'V');
		h.put('W', 'W');
		h.put('X', 'X');
		h.put('Y', 'Y');
		h.put('5', 'Z');
		h.put('1', '1');
		h.put('S', '2');
		h.put('E', '3');
		h.put('Z', '5');
		h.put('8', '8');
		for (String line ; (line = in.readLine()) != null  ; ) {
			String l = line.trim();
			char[] p = l.toCharArray();
			boolean mirrored = true;
			boolean palindrome = true;
			for (int i = 0 , j = p.length-1 ; i <= j; i++, j-- ) {
				if( p[i]!=p[j] ) palindrome = false;
				if( h.containsKey(p[i]) && h.get(p[i])!=p[j] ) mirrored=false;
				else if( !h.containsKey(p[i]) ) mirrored = false;
			}
			if( palindrome && mirrored ) 
				out.append(l+" -- is a mirrored palindrome.\n");
			else if(palindrome)
				out.append(l+" -- is a regular palindrome.\n");
			else if(mirrored)
				out.append(l+" -- is a mirrored string.\n");
			else
				out.append(l+" -- is not a palindrome.\n");
			out.append("\n");
		}
		System.out.print(new String(out));
	}

}
