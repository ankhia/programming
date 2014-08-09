/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&category=24&problem=1137&mosmsg=Submission+received+with+ID+14010747
 * @veredict Accepted 
 * @problemId 10196
 * @problemName  Check the Check
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level Implementation, Ad hoc
 * @date 08/08/2014
 **/ 

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Uva10196 {

	static char[][] chess;
	static boolean end;
	static int wki ; //upper bottom
	static int wkj ; 
	static int bki ; //lower top
	static int bkj;
	static StringBuilder sb;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		chess = new char[8][8];
		end = false;
		sb = new StringBuilder( );
		int ncase = 1;
		while ( !end ) {
			
			for (int i = 0; i < 8; i++) {
				String line = in.readLine();
				for (int j = 0; j < 8; j++) {
					chess[i][j] = line.charAt(j);
					if( chess[i][j] == 'k' ) { bki = i ; bkj = j; }
					if( chess[i][j] == 'K' ) { wki = i; wkj = j; }
				}
			}
			end = isEnd( );
			if( !end ){
				sb.append("Game #").append(ncase).append(": ");
				in.readLine();
				solve( );
				ncase++;
			}
		} 
		System.out.print(new String(sb));
	}
	
	private static void solve( ){
		boolean white = validateWhite();
		boolean black = validateBlack();
		if( !white && !black) 
			sb.append("no king is in check.\n");
		else if( white )
			sb.append("white king is in check.\n");
		else 
			sb.append("black king is in check.\n");
	}
	
	private static boolean validateWhite( ){
		int i = wki, j = wkj ; 
		boolean inCheck = false ;
		//knight
		if( i-2 >= 0 && j-1 >= 0 && chess[i-2][j-1] == 'n' ) inCheck = true;
		if( i-1 >= 0 && j-2 >= 0 && chess[i-1][j-2] == 'n' ) inCheck = true;
		if( i+1  < 8 && j-2 >= 0 && chess[i+1][j-2] == 'n' ) inCheck = true;
		if( i+2  < 8 && j-1 >= 0 && chess[i+2][j-1] == 'n' ) inCheck = true;
		if( i-2 >= 0 && j+1  < 8 && chess[i-2][j+1] == 'n' ) inCheck = true;
		if( i-1 >= 0 && j+2  < 8 && chess[i-1][j+2] == 'n' ) inCheck = true;
		if( i+1  < 8 && j+2  < 8 && chess[i+1][j+2] == 'n' ) inCheck = true;
		if( i+2  < 8 && j+1  < 8 && chess[i+2][j+1] == 'n' ) inCheck = true;
		
		//pawn
		if( i-1 >= 0 && j-1 >= 0 && chess[i-1][j-1] == 'p') inCheck = true;
		if( i-1 >= 0 && j+1  < 8 && chess[i-1][j+1] == 'p') inCheck = true;
		
		//rook and queen
		boolean found = false;
		for (int k = j; k >=0 && !found ; k--){
			if( chess[i][k] != 'r' && chess[i][k] != 'q' &&  chess[i][k] != '.' && chess[i][k] != 'K')
				found = true;
			if( chess[i][k] == 'r' || chess[i][k] == 'q' ) {
				inCheck = true;
			}
		}
		found = false;
		for (int k = i; k >=0 && !found; k--){
			if( chess[k][j] != 'r' && chess[k][j] != 'q' &&  chess[k][j] != '.' && chess[k][j] != 'K')
				found = true;
			if( chess[k][j] == 'r' || chess[k][j] == 'q' ) {
				inCheck = true;
			}
		}
		found = false;
		for (int k = i; k < 8 && !found; k++){
			if( chess[k][j] != 'r' && chess[k][j] != 'q' &&  chess[k][j] != '.' && chess[k][j] != 'K')
				found = true;
			if( chess[k][j] == 'r' || chess[k][j] == 'q' ) {
				inCheck = true;
			}
		}
		found = false;
		for (int k = j; k < 8 && !found; k++){
			if( chess[i][k] != 'r' && chess[i][k] != 'q' &&  chess[i][k] != '.' && chess[i][k] != 'K')
				found = true;
			if( chess[i][k] == 'r' || chess[i][k] == 'q' ){
				inCheck =  true;
			}
		}
		
		//bishop and queen
		found = false;
		for (int k = i, l = j ; k >=0 && l>=0 && !found; k--, l--){
			if( chess[k][l] != 'b' && chess[k][l] != 'q' && chess[k][l] != '.' && chess[k][l] != 'K')
				found = true;
			if( chess[k][l] == 'b' || chess[k][l] == 'q' ) 
				inCheck = true;
		}
		found = false;
		for (int k = i, l = j ; k <8 && l <8  && !found; k++, l++){
			if( chess[k][l] != 'b' && chess[k][l] != 'q' && chess[k][l] != '.' && chess[k][l] != 'K')
				found = true;
			if( chess[k][l] == 'b' || chess[k][l] == 'q' ) {
				inCheck = true;
			}
		}
		found=false;
		for (int k = i, l = j ; k >=0 && l<8 && !found; k--, l++){
			if( chess[k][l] != 'b' && chess[k][l] != 'q' && chess[k][l] != '.' && chess[k][l] != 'K')
				found = true;
			if( chess[k][l] == 'b' || chess[k][l] == 'q' )
				inCheck =  true;
		}
		found = false;
		for (int k = i, l = j ; k <8 && l>=0  && !found; k++, l--){
			if( chess[k][l] != 'b' && chess[k][l] != 'q' && chess[k][l] != '.' && chess[k][l] != 'K')
				found = true;
			if( chess[k][l] == 'b' || chess[k][l] == 'q' ) {
				inCheck = true;
			}
		}
		return inCheck;
	}
	
	private static boolean validateBlack( ){
		int i = bki, j = bkj ; 
		boolean inCheck = false ;
		//knight
		if( i-2 >= 0 && j-1 >= 0 && chess[i-2][j-1] == 'N' ) inCheck = true;
		if( i-1 >= 0 && j-2 >= 0 && chess[i-1][j-2] == 'N' ) inCheck = true;
		if( i+1  < 8 && j-2 >= 0 && chess[i+1][j-2] == 'N' ) inCheck = true;
		if( i+2  < 8 && j-1 >= 0 && chess[i+2][j-1] == 'N' ) inCheck = true;
		if( i-2 >= 0 && j+1  < 8 && chess[i-2][j+1] == 'N' ) inCheck = true;
		if( i-1 >= 0 && j+2  < 8 && chess[i-1][j+2] == 'N' ) inCheck = true;
		if( i+1  < 8 && j+2  < 8 && chess[i+1][j+2] == 'N' ) inCheck = true;
		if( i+2  < 8 && j+1  < 8 && chess[i+2][j+1] == 'N' ) inCheck = true;
		
		//pawn
		if( i+1 < 8 && j+1 <  8 && chess[i+1][j+1] == 'P') inCheck = true;
		if( i+1 < 8 && j-1 >= 0 && chess[i+1][j-1] == 'P') inCheck = true;
		
		//rook and queen
		boolean found = false;
		for (int k = j; k >=0 && !found ; k--){
			if( chess[i][k] != 'R' && chess[i][k] != 'Q' &&  chess[i][k] != '.' && chess[i][k] != 'k')
				found = true;
			if( chess[i][k] == 'R' || chess[i][k] == 'Q' ) {
				inCheck = true;
			}
		}
		found = false;
		for (int k = i; k >=0 && !found; k--){
			if( chess[k][j] != 'R' && chess[k][j] != 'Q' &&  chess[k][j] != '.' && chess[k][j] != 'k')
				found = true;
			if( chess[k][j] == 'R' || chess[k][j] == 'Q' ) {
				inCheck = true;
			}
		}
		found = false;
		for (int k = i; k < 8 && !found; k++){
			if( chess[k][j] != 'R' && chess[k][j] != 'Q' &&  chess[k][j] != '.' && chess[k][j] != 'k')
				found = true;
			if( chess[k][j] == 'R' || chess[k][j] == 'Q' ) {
				inCheck = true;
			}
		}
		found = false;
		for (int k = j; k < 8 && !found; k++){
			if( chess[i][k] != 'R' && chess[i][k] != 'Q' &&  chess[i][k] != '.' && chess[i][k] != 'k'){
				found = true;	
			}
			if( chess[i][k] == 'R' || chess[i][k] == 'Q' ){
				inCheck =  true;
			}
		}
		
		//bishop and queen
		found = false;
		for (int k = i, l = j ; k >=0 && l>=0 && !found; k--, l--){
			if( chess[k][l] != 'B' && chess[k][l] != 'Q' && chess[k][l] != '.' && chess[k][l] != 'k')
				found = true;
			if( chess[k][l] == 'B' || chess[k][l] == 'Q' ) 
				inCheck = true;
		}
		found = false;
		for (int k = i, l = j ; k <8 && l <8  && !found; k++, l++){
			if( chess[k][l] != 'B' && chess[k][l] != 'Q' && chess[k][l] != '.' && chess[k][l] != 'k')
				found = true;
			if( chess[k][l] == 'B' || chess[k][l] == 'Q' ) {
				inCheck = true;
			}
		}
		found=false;
		for (int k = i, l = j ; k >=0 && l<8 && !found; k--, l++){
			if( chess[k][l] != 'B' && chess[k][l] != 'Q' && chess[k][l] != '.' && chess[k][l] != 'k')
				found = true;
			if( chess[k][l] == 'B' || chess[k][l] == 'Q' )
				inCheck =  true;
		}
		found = false;
		for (int k = i, l = j ; k <8 && l>=0  && !found; k++, l--){
			if( chess[k][l] != 'B' && chess[k][l] != 'Q' && chess[k][l] != '.' && chess[k][l] != 'k')
				found = true;
			if( chess[k][l] == 'B' || chess[k][l] == 'Q' ) {
				inCheck = true;
			}
		}
		return inCheck;
	}
	
	private static boolean isEnd( ){
		boolean end = true;
		for (int i = 0; i < chess.length && end; i++) {
			for (int j = 0; j < chess.length && end; j++) {
				if( chess[i][j] != '.')
					end = false;
			}
		}
		return end;
	}
}
