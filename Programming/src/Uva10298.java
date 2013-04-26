

import static java.lang.Integer.MIN_VALUE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Uva10298 {
	
	public static void main(String[] args) throws Throwable{
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String linea; !(linea = bf.readLine()).equals("."); ) {
			boolean cierto = todasIguales(linea);
			if( cierto )
				sb.append(linea.length()+"\n");
			else {
				
				int hayRespuesta = solve(linea);
				if(hayRespuesta==MIN_VALUE)
					sb.append(1+"\n");
				else
					sb.append(hayRespuesta+"\n");
				
			}
		}
		System.out.println(new String(sb));
	}
	public static boolean todasIguales( String linea){
		for (int i = 0; i < linea.length(); i++) {
			if( (i+1)<linea.length() )
				if( linea.charAt(i)!=linea.charAt(i+1) )
					return false;
		}
		return true;
	}
	
	public static int solve(String linea){
		
		int max = MIN_VALUE;
		LinkedList<String> array;
		int tam = linea.length();
		for (int i = 1; i < tam ; i++) {
			if(tam%i == 0){
				array = new LinkedList<String>();
				int pos = 0;
				int p = i;
				while( (pos+p)-1 < tam ){
					array.add(linea.substring(pos, (pos+p)));
					pos+=p;
				}
				if(todasIguales(array)){
					if(tam/i>max) max = tam/i;
//					System.out.println(tam+" "+i+" "+max);
				}
			}
		}
		return max;
	}
	private static boolean todasIguales(List<String> array) {
		String compara = array.get(0);
//		System.out.println(compara);
		for (String a : array) {
//			System.out.println(a);
			if(!a.equals(compara)){
//				System.out.println("no hay igual una");
				return false;
			}
				
		}
		return true;
	}
}
