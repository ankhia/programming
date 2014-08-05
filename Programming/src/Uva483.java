

import java.io.*;

public class Uva483 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String linea; (linea = in.readLine())!=null;) {
			String[] palabras = linea.split(" ");
			for (int i = 0; i < palabras.length; i++) {
				sb.append(new StringBuilder(palabras[i]).reverse());
				if(i<palabras.length-1)	sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}
