

import java.io.*;

public class Acm2451 {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		for (int h = 0; h < n; h++) {
			in.readLine();
			String entrada = in.readLine();
			String salida = "";
			int ultimoOval = -1;
			int ultimoCuadrado = -1;

			for (int i = 0; i < entrada.length(); i++) {
				char actual = entrada.charAt(i);
				if( actual == ']'){
					if( entrada.substring(0,i).length()==0 ){
						entrada = entrada.substring(i+1);
						i=-1;
						salida += "[]";
					}
				}else if( actual == ')' ){
					if( entrada.substring(0,i).length()==0 ){
						entrada = entrada.substring(i+1);
						i=-1;
						salida += "[]";
					}
				}else if(actual=='['){
					if( entrada.indexOf(']') == -1 ){
						salida+="[]";
					}
					else{
						
					}
						
				}else{
					if( entrada.lastIndexOf(')') == -1 ){
						salida+="()";
					}
					else{
						
					}
				}
			}
			System.out.println(salida);
		}
	}
}
