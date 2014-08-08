

import java.io.*;

public class Uva10945 {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String linea; (linea=in.readLine())!=null; ) {
			if(linea.equals("DONE")) break;
			linea = linea.trim();
			linea = linea.toLowerCase();
			StringBuilder nuevaLinea = new StringBuilder();
			for (int i = 0; i < linea.length(); i++) {
				if(Character.isLetter(linea.charAt(i))){
					nuevaLinea.append(linea.charAt(i));
				}
			}
			if(nuevaLinea.toString().equals(nuevaLinea.reverse().toString()))
				sb.append("You won't be eaten!\n");
			else
				sb.append("Uh oh..\n");
		}
		System.out.print(new String(sb));
	}
}
