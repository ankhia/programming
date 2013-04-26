
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=38
 * @veredict Accepted 
 * @problemId 102
 * @problemName  Ecological Bin Packing
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level easy
 * @date 13/11/2011
 **/

public class Uva102 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		while((linea=bf.readLine())!=null){
			String[] boxes = linea.split(" ");
			long totalCajas = 0 ;
			for(int i=0;i<boxes.length;++i){
				totalCajas += Integer.parseInt(boxes[i]);
			}

			String ordenCajas;
			int menorNumMov = Integer.MAX_VALUE;

			ordenCajas = "BCG";
			menorNumMov = (int) (totalCajas - ( Integer.parseInt(boxes[0]) + Integer.parseInt(boxes[5]) + Integer.parseInt(boxes[7])));

			int aux = (int) (totalCajas - ( Integer.parseInt(boxes[0]) + Integer.parseInt(boxes[4]) + Integer.parseInt(boxes[8]))); 
			if( aux < menorNumMov ){
				ordenCajas = "BGC";
				menorNumMov = aux;
			}

			aux = (int) (totalCajas - ( Integer.parseInt(boxes[2]) + Integer.parseInt(boxes[3]) + Integer.parseInt(boxes[7])));
			if( aux < menorNumMov ){
				ordenCajas = "CBG";
				menorNumMov = aux;
			}

			aux = (int) (totalCajas - ( Integer.parseInt(boxes[2]) + Integer.parseInt(boxes[4]) + Integer.parseInt(boxes[6])));
			if( aux < menorNumMov ){
				ordenCajas = "CGB";
				menorNumMov = aux;
			}

			aux = (int) (totalCajas - ( Integer.parseInt(boxes[1]) + Integer.parseInt(boxes[3]) + Integer.parseInt(boxes[8])));
			if( aux < menorNumMov ){
				ordenCajas = "GBC";
				menorNumMov = aux;
			}

			aux = (int) (totalCajas - ( Integer.parseInt(boxes[1]) + Integer.parseInt(boxes[5]) + Integer.parseInt(boxes[6])));
			if( aux < menorNumMov ){
				ordenCajas = "GCB";
				menorNumMov = aux;
			}

			System.out.println(ordenCajas+" "+menorNumMov);
		}
	}
}
