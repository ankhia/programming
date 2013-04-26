
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=435
 * @veredict Accepted 
 * @problemId 494
 * @problemName  Kindergarten Counting Game
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level easy
 * @date 12/11/2011
 **/ 

public class Uva494 {

	public static void main(String[] args) throws Throwable {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		while((linea=bf.readLine())!=null){
			int contador = 0;
			for (int i = 0; i < linea.length(); i++) {
				if(!Character.isLetter(linea.charAt(i)) && (i-1) >= 0 ){
					if(Character.isLetter(linea.charAt(i-1))){
						contador++;
					}
				}
			}
			if(Character.isLetter(linea.charAt(linea.length()-1)))
				contador++;
			System.out.println(contador);
		}
	}
}
