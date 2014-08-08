import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class CodeJamA_TicTacToe {

	static char [][] m ;
	static int DRAW = 1;
	static int X = 2;
	static int O = 3;
	static int INCOMPLETE = 4;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tC = Integer.parseInt(in.readLine());
		for (int t = 0; t < tC; t++) {
			sb.append("Case #"+(t+1)+": ");
			m = new char[4][4];
			for (int f = 0; f < m.length; f++) {
				String line = in.readLine();
				for (int c = 0; c < m[0].length; c++) {
					m[f][c] = line.charAt(c); 
				}
			}
			
			int sol = solve();
			if( sol == DRAW ) 
				sb.append("Draw\n");
			else if( sol == X )
				sb.append("X won\n");
			else if( sol == O )
				sb.append("O won\n");
			else
				sb.append("Game has not completed\n");
			
			in.readLine( );
		}
		System.out.print(new String(sb));
	}
	
	public static boolean tabLleno( ){
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if( m[i][j]=='.' ){
					return false;
				}
			}
		}
		return true;
	}
	
	public static int solve( ){
		for (int i = 0; i < m.length ; i++) {
			int contX = 0;
			int contY = 0;
			for(int j=0;j<m[i].length;++j){
				if(m[i][j]=='X')
					contX++;
				else if(m[i][j]=='O')
					contY++;
				else if(m[i][j]=='T')
				{
					contX++;
					contY++;
				}
				if(contX==4 && contY<4)
					return X;
				if(contY==4 && contX<4)
					return O;
			}
			
		}
		
		for (int i = 0; i < m.length ; i++) {
			int contX = 0;
			int contY = 0;
			for(int j=0;j<m[i].length;++j){
				if(m[j][i]=='X')
					contX++;
				else if(m[j][i]=='O')
					contY++;
				else if(m[j][i]=='T')
				{
					contX++;
					contY++;
				}
				if(contX==4 && contY<4)
					return X;
				if(contY==4 && contX<4)
					return O;
			}
			
		}
		
		int contX = 0;
		int contY = 0;
		for (int i = 0; i < m.length ; i++) {
				if(m[i][i]=='X')
					contX++;
				else if(m[i][i]=='O')
					contY++;
				else if(m[i][i]=='T')
				{
					contX++;
					contY++;
				}
				if(contX==4 && contY<4)
					return X;
				if(contY==4 && contX<4)
					return O;
		}
	
		contX = 0;
		contY = 0;
		for (int i = 0 , j = m.length-1; i < m.length && j >= 0  ; i++, j--) {
			
				if(m[i][j]=='X')
					contX++;
				else if(m[i][j]=='O')
					contY++;
				else if(m[i][j]=='T')
				{
					contX++;
					contY++;
				}
				if(contX==4 && contY<4)
					return X;
				if(contY==4 && contX<4)
					return O;
		}
		
		if(tabLleno())
			return DRAW;
		else
			return INCOMPLETE;
	}
	

}
