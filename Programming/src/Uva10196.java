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
			if( chess[i][k] != 'r' && chess[i][k] != 'q' &&  chess[i][k] == '.' )
				found = true;
			if( chess[i][k] == 'r' || chess[i][k] == 'q' ) {
				inCheck = true;
			}
		}
		found = false;
		for (int k = i; k >=0 && !found; k--){
			if( chess[i][k] != 'r' && chess[i][k] != 'q' &&  chess[i][k] == '.' )
				found = true;
			if( chess[k][j] == 'r' || chess[i][k] == 'q' ) {
				inCheck = true;
			}
		}
		found = false;
		for (int k = i; k < 8 && !found; k++){
			if( chess[i][k] != 'r' && chess[i][k] != 'q' &&  chess[i][k] == '.' )
				found = true;
			if( chess[k][j] == 'r' || chess[i][k] == 'q' ) {
				inCheck = true;
			}
		}
		found = false;
		for (int k = j; k < 8; k++){
			if( chess[i][k] != 'r' && chess[i][k] != 'q' &&  chess[i][k] == '.' )
				found = true;
			if( chess[i][k] == 'r' || chess[i][k] == 'q' ){
				inCheck =  true;
			}
		}
		
		//bishop and queen
		found = false;
		for (int k = i, l = j ; k >=0 && l>=0 && !found; k--, l--){
			if( chess[k][l] != 'b' && chess[i][k] != 'q' && chess[k][l] == '.')
				found = true;
			if( chess[k][l] == 'b' || chess[i][k] == 'q' ) 
				inCheck = true;
		}
		found = false;
		for (int k = i, l = j ; k <8 && l <8  && !found; k++, l++){
			if( chess[k][l] != 'b' && chess[i][k] != 'q' && chess[k][l] == '.')
				found = true;
			if( chess[k][l] == 'b' || chess[i][k] == 'q' ) {
				inCheck = true;
			}
		}
		found=false;
		for (int k = i, l = j ; k >=0 && l <8 && !found; k--, l++){
			if( chess[k][l] != 'b' && chess[i][k] != 'q' && chess[k][l] == '.')
				found = true;
			if( chess[k][l] == 'b' || chess[i][k] == 'q' ){
				inCheck =  true;
			}
		}
		found = false;
		for (int k = i, l = j ; k <8 && l>=0  && !found; k++, l--){
			if( chess[k][l] != 'b' && chess[i][k] != 'q' && chess[k][l] == '.')
				found = true;
			if( chess[k][l] == 'b' || chess[i][k] == 'q' ) {
				inCheck = true;
			}
		}
		return inCheck;
	}
	
	private static boolean validateBlack( ){
		int i = wki, j = wkj ; 
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
		if( i+1 < 8 && j+1 < 8  && chess[i+1][j+1] == 'P') inCheck = true;
		if( i+1 < 8 && j-1 >=0  && chess[i+1][j-1] == 'P') inCheck = true;
		
		//rook and queen
		boolean found = false;
		for (int k = j; k >=0 && !found ; k--){
			if( chess[i][k] != 'R' && chess[i][k] != 'Q' &&  chess[i][k] == '.' )
				found = true;
			if( chess[i][k] == 'R' || chess[i][k] == 'Q' ) {
				inCheck = true;
			}
		}
		found = false;
		for (int k = i; k >=0 && !found; k--){
			if( chess[i][k] != 'R' && chess[i][k] != 'Q' &&  chess[i][k] == '.' )
				found = true;
			if( chess[k][j] == 'R' || chess[i][k] == 'Q' ) {
				inCheck = true;
			}
		}
		found = false;
		for (int k = i; k < 8 && !found; k++){
			if( chess[i][k] != 'R' && chess[i][k] != 'Q' &&  chess[i][k] == '.' )
				found = true;
			if( chess[k][j] == 'R' || chess[i][k] == 'Q' ) {
				inCheck = true;
			}
		}
		found = false;
		for (int k = j; k < 8; k++){
			if( chess[i][k] != 'R' && chess[i][k] != 'Q' &&  chess[i][k] == '.' )
				found = true;
			if( chess[i][k] == 'R' || chess[i][k] == 'Q' ){
				inCheck =  true;
			}
		}
		
		//bishop and queen
		found = false;
		for (int k = i, l = j ; k >=0 && l>=0 && !found; k--, l--){
			if( chess[k][l] != 'B' && chess[i][k] != 'Q' && chess[k][l] == '.')
				found = true;
			if( chess[k][l] == 'B' || chess[i][k] == 'Q' ) 
				inCheck = true;
		}
		found = false;
		for (int k = i, l = j ; k <8 && l <8  && !found; k++, l++){
			if( chess[k][l] != 'B' && chess[i][k] != 'Q' && chess[k][l] == '.')
				found = true;
			if( chess[k][l] == 'B' || chess[i][k] == 'Q' ) {
				inCheck = true;
			}
		}
		found=false;
		for (int k = i, l = j ; k >=0 && l <8 && !found; k--, l++){
			if( chess[k][l] != 'B' && chess[i][k] != 'Q' && chess[k][l] == '.')
				found = true;
			if( chess[k][l] == 'B' || chess[i][k] == 'Q' ){
				inCheck =  true;
			}
		}
		found = false;
		for (int k = i, l = j ; k <8 && l>=0  && !found; k++, l--){
			if( chess[k][l] != 'B' && chess[i][k] != 'Q' && chess[k][l] == '.')
				found = true;
			if( chess[k][l] == 'B' || chess[i][k] == 'Q' ) {
				inCheck = true;
			}
		}
		return inCheck;
	}
	
	
//	
//	private static boolean whiteKing( ){
//
//		if( wki-2 >= 0 && wkj-1 >= 0 && chess[wki-2][wkj-1]=='n' )
//			return true;
//		if( wki-1 >= 0 && wkj-2 >= 0 && chess[wki-1][wkj-2]=='n' )
//			return true;
//		if( wki+1 <  8 && wkj-2 >= 0 && chess[wki+1][wkj-2]=='n' )
//			return true;
//		if( wki+2 <  8 && wkj-1 >= 0 && chess[wki+2][wkj-1]=='n' )
//			return true;
//		if( wki-2 >= 0 && wkj+1 <  8  && chess[wki-2][wkj+1]=='n')
//			return true;
//		if( wki-1 >= 0 && wkj+2 <  8  && chess[wki-1][wkj+2]=='n')
//			return true;
//		if( wki+1 <  8 && wkj+2 <  8  && chess[wki+1][wkj+2]=='n')
//			return true;
//		if( wki+2 <  8 && wkj+1 <  8  && chess[wki+2][wkj+1]=='n')
//			return true;
//		
//		if( (wki-1)>=0 && wkj-1>=0 && ( chess[wki-1][wkj-1] == 'q' || chess[wki-1][wkj-1] == 'p' ) )
//			return true;
//		if( wkj-1 >=0 && chess[wki][wkj-1] == 'q')
//			return true;
//		if( wki+1<8 && wkj-1 >=0 && chess[wki+1][wkj-1] == 'q')
//			return true;
//		if( wki+1<8 && chess[wki+1][wkj] == 'q')
//			return true;
//		if( wki+1<8 && wkj+1 < 8 && chess[wki+1][wkj+1] == 'q')
//			return true;
//		if( wkj+1 <8 && chess[wki][wkj+1] == 'q')
//			return true;
//		if( wki-1>=0 && wkj+1 <8 && ( chess[wki-1][wkj+1] == 'p' || chess[wki-1][wkj+1] == 'q') )
//			return true;
//		if( wki-1 >=0 && chess[wki-1][wkj] == 'q')
//			return true;
//		
//		for( int i = wki, j = wkj; i>=0 && j<8 ; i--,j++ )
//			if( chess[i][j] == 'b' || chess[i][j] == 'q' )
//				return true;
//		for( int i = wki, j = wkj; i<8 && j>=0 ; i++,j-- )
//			if( chess[i][j] == 'b' || chess[i][j] == 'q' )
//				return true;
//		for( int i = wki, j = wkj; i>=0 && j>=0; i--,j-- )
//			if( chess[i][j] == 'b' || chess[i][j] == 'q' )
//				return true;
//		for( int i = wki, j = wkj; i<8 && j<8 ; i++,j++ )
//			if( chess[i][j] == 'b' || chess[i][j] == 'q' )
//				return true;
//		
//		for(int i = wki; i>=0; i--)
//			if( chess[i][wkj] == 'r' || chess[i][wkj] == 'q' )
//				return true;
//		for(int i = wki; i<8; i++)
//			if( chess[i][wkj] == 'r' || chess[i][wkj] == 'q' )
//				return true;
//		for(int j = wkj; j>=0; j--)
//			if( chess[wki][j] == 'r' || chess[wki][j] == 'q' )
//				return true;
//		for(int j = wkj; j<8; j++)
//			if( chess[wki][j] == 'r' || chess[wki][j] == 'q' )
//				return true;
//		
//		return false;
//	}
//	
//	private static boolean blackKing( ){
//		if( bki-2 >= 0 && bkj-1 >= 0  && chess[bki-2][bkj-1]=='N' )
//			return true;
//		if( bki-1 >= 0 && bkj-2 >= 0  && chess[bki-1][bkj-2]=='N' )
//			return true;
//		if( bki+1 <  8 && bkj-2 >= 0  && chess[bki+1][bkj-2]=='N' )
//			return true;
//		if( bki+2 <  8 && bkj-1 >= 0  && chess[bki+2][bkj-1]=='N' )
//			return true;
//		if( bki-2 >= 0 && bkj+1 <  8  && chess[bki-2][bkj+1]=='N')
//			return true;
//		if( bki-1 >= 0 && bkj+2 <  8  && chess[bki-1][bkj+2]=='N')
//			return true;
//		if( bki+1 <  8 && bkj+2 <  8  && chess[bki+1][bkj+2]=='N')
//			return true;
//		if( bki+2 <  8 && bkj+1 <  8  && chess[bki+2][bkj+1]=='N')
//			return true;
//		
//		if( bki-1>=0 && bkj-1 >=0 && chess[bki-1][bkj-1] == 'Q')
//			return true;
//		if( bkj-1 >=0 && chess[bki][bkj-1] == 'Q')
//			return true;
//		if( bki+1<8 && bkj-1 >=0 && (chess[bki+1][bkj-1] == 'P' || chess[bki+1][bkj-1] == 'Q'))
//			return true;
//		if( bki+1<8 && chess[bki+1][bkj] == 'Q')
//			return true;
//		if( bki+1<8 && bkj+1 < 8 && (chess[bki+1][bkj+1] == 'P' || chess[bki+1][bkj+1] == 'Q'))
//			return true;
//		if( bkj+1<8 && chess[bki][bkj+1] == 'Q')
//			return true;
//		if( bki-1>=0 && bkj+1 <8 && chess[bki-1][bkj+1] == 'Q')
//			return true;
//		if( bki-1 >=0 && chess[bki-1][bkj] == 'Q')
//			return true;
//		
//		for( int i = bki, j = bkj; i>=0 && j<8 ; i--,j++ )
//			if( chess[i][j] == 'B' || chess[i][j] == 'Q' )
//				return true;
//		for( int i = bki, j = bkj; i<8 && j>=0 ; i++,j-- )
//			if( chess[i][j] == 'B' || chess[i][j] == 'Q' )
//				return true;
//		for( int i = bki, j = bkj; i>=0 && j>=0; i--,j-- )
//			if( chess[i][j] == 'B' || chess[i][j] == 'Q' )
//				return true;
//		for( int i = bki, j = bkj; i<8 && j<8 ; i++,j++ )
//			if( chess[i][j] == 'B' || chess[i][j] == 'Q' )
//				return true;
//		
//		for(int i = bki; i>=0; i--)
//			if( chess[i][bkj] == 'R' || chess[i][bkj] == 'Q' )
//				return true;
//		for(int i = bki; i<8; i++)
//			if( chess[i][bkj] == 'R' || chess[i][bkj] == 'Q' )
//				return true;
//		for(int j = bki; j>=0; j--)
//			if( chess[bki][j] == 'R' || chess[bki][j] == 'Q' )
//				return true;
//		for(int j = bki; j<8; j++)
//			if( chess[bki][j] == 'R' || chess[bki][j] == 'Q' )
//				return true;
//		
//		return false;
//	}
	
	private static void print( ){
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess[0].length; j++) {
				System.out.print( chess[i][j]);
			}
			System.out.println();
		}
		System.out.println();
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
