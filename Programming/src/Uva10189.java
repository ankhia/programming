
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=29&page=show_problem&problem=1130
 * @veredict Accepted 
 * @problemId 10189
 * @problemName  Minesweeper
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level easy
 * @date 13/11/2011
 **/
public class Uva10189 {

	private static String m[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int fil = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int field = 1;
		while( !( fil == 0 && col == 0 ) ){
			m = new String[fil][col];
			for(int i=0; i < fil; i++){
				String linea = bf.readLine();
				for(int j = 0 ; j < linea.length(); j++){
					m[i][j]=linea.charAt(j)+"";
				}
			}
			
			for(int i = 0; i < fil; i++){
				for(int j = 0 ; j < col; j++){
					if(m[i][j].equals(".")){
						m[i][j]=darBombas(i,j)+"";
					}
				}
			}
			System.out.println("Field #"+field+":");
			for(int i=0; i<fil; i++){
				for(int j = 0 ; j< col; j++){
					System.out.print(m[i][j]);
				}
				System.out.println();
			}
			
			st = new StringTokenizer(bf.readLine());
			fil = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			field++;
			if( fil!=0 && col != 0)
				System.out.println();
		}
	}
	
	public static int darBombas( int i , int j ) {
		int cont = 0;
		int lala = bombasLados(i, j);
		
		if( i+1 < m.length ){
			if( j+1 < m[0].length){
				if(m[i+1][j+1].equals("*")) cont++;
			}
			if( j-1 >= 0 ){
				if(m[i+1][j-1].equals("*")) cont++;
			}
		}
		if( i-1 >= 0 ){
			if( j-1 >= 0 ){
				if(m[i-1][j-1].equals("*")) cont++;
			}
			if( j+1 < m[0].length){
				if(m[i-1][j+1].equals("*")) cont++;
			}
		}
		
		return cont + lala;
	}
	
 	public static int bombasLados( int i, int j )
 	{
 		int cont = 0;
 		if( j+1 < m[0].length){
 			if( m[i][j+1].equals("*") )cont++;
 		}
 		if( j-1 >= 0 ){
 			if( m[i][j-1].equals("*") )cont++;
 		}
 		if( i+1 < m.length){
 			if( m[i+1][j].equals("*") )cont++;
 		}
 		if( i-1 >= 0 ){
 			if( m[i-1][j].equals("*") )cont++;
 		}
 		return cont;
 	}
}
