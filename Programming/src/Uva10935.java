

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1876
 * @veredict Accepted 
 * @problemId 10935
 * @problemName  Throwing cards away I
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level easy
 * @date 13/04/2012
 **/ 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Uva10935 {

	public static void main(String[] args) throws Throwable {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int cartas = Integer.parseInt(bf.readLine());
		while( cartas != 0 ){
			
						
			ArrayList<Integer> numeros = new ArrayList<Integer>();
			int[] discards = new int[cartas-1];
			for (int i = 1; i <= cartas; i++) {
				numeros.add(i);
			}
			int cosa = 0;
			for (int i = 0; i < numeros.size(); i++) {
				if(cosa<discards.length){
					discards[cosa] = numeros.get(i);
					cosa++;
				}
				if( (i+1) < numeros.size() && (i+2) < numeros.size())
					numeros.add(numeros.get(i+1));
				i++;
			}
			
			String discarded = "Discarded cards: ";
			for (int i = 0; i < discards.length; i++) {
				discarded+=discards[i]+", ";
			}
			if(discards.length>0)
				discarded = discarded.substring(0, discarded.length()-2);
			else{
				discarded =  discarded.substring(0, discarded.length()-1);
			}
			System.out.println(discarded);
			System.out.print("Remaining card: ");
			System.out.println(numeros.get(numeros.size()-1));
			cartas = Integer.parseInt(bf.readLine());
		}
	}
}
