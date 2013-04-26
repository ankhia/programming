  

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva706 {

	private static char [][]m;
	private static int fil;
	private static int col;
	private static int c;

	public static void main(String[] args) throws Exception {
		m = new char [24][105];
		limpiarMatriz(24, 105);

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int cLineas = Integer.parseInt(st.nextToken());
		String numero = st.nextToken();
		while(!( cLineas == 0 && numero.equals("0") )){
			fil = 0;
			col = 0;
			c = cLineas;
			for( int i = 0 ; i < numero.length(); i++ )
			{
				switch( Integer.parseInt(numero.charAt(i)+"") ){
				case 1:
					pintarBitVertical( 3 );
					pintarBitVertical( 6 );
					calcularFilCol( );
					break;
				case 2:
					pintarBitHorizontal( 1 );
					pintarBitHorizontal( 4 );
					pintarBitHorizontal( 7 );
					pintarBitVertical( 3 );
					pintarBitVertical( 5 );
					calcularFilCol( ); 
					break;
				case 3:
					pintarBitHorizontal( 1 );
					pintarBitHorizontal( 4 );
					pintarBitHorizontal( 7 );
					pintarBitVertical( 3 );
					pintarBitVertical( 6 );
					calcularFilCol( ); 
					break;
				case 4:
					pintarBitHorizontal( 4 );
					pintarBitVertical( 2 );
					pintarBitVertical( 3 );
					pintarBitVertical( 6 );
					calcularFilCol( ); 
					break;
				case 5:
					pintarBitHorizontal( 1 );
					pintarBitHorizontal( 4 );
					pintarBitHorizontal( 7 );
					pintarBitVertical( 2 );
					pintarBitVertical( 6 );
					calcularFilCol( ); 
					break;
				case 6:
					pintarBitHorizontal( 1 );
					pintarBitHorizontal( 4 );
					pintarBitHorizontal( 7 );
					pintarBitVertical( 2 );
					pintarBitVertical( 5 );
					pintarBitVertical( 6 );
					calcularFilCol( ); 
					break;
				case 7:
					pintarBitHorizontal( 1 );
					pintarBitVertical( 3 );
					pintarBitVertical( 6 );
					calcularFilCol( ); 
					break;
				case 8:
					pintarBitHorizontal( 1 );
					pintarBitHorizontal( 4 );
					pintarBitHorizontal( 7 );
					pintarBitVertical( 3 );
					pintarBitVertical( 6 );
					pintarBitVertical( 2 );
					pintarBitVertical( 5 );
					calcularFilCol( ); 
					break;
				case 9:
					pintarBitHorizontal( 1 );
					pintarBitHorizontal( 4 );
					pintarBitHorizontal( 7 );
					pintarBitVertical( 2 );
					pintarBitVertical( 3 );
					pintarBitVertical( 6 );
					calcularFilCol( ); 
					break;
				case 0:
					pintarBitHorizontal( 1 );
					pintarBitHorizontal( 7 );
					pintarBitVertical( 3 );
					pintarBitVertical( 6 );
					pintarBitVertical( 2 );
					pintarBitVertical( 5 );
					calcularFilCol( ); 
					break;
				}
			}
			StringBuilder sb = new StringBuilder();
			int tamanioTotalFilas = 3 + c*2;
			int numEspacios = numero.length()-1;
			int tamanioTotalColumnas = (( 2 + c ) * numero.length())+numEspacios;
			for(int i = 0 ; i < tamanioTotalFilas; i++){
				for (int j = 0; j < tamanioTotalColumnas ; j++){
					sb.append(m[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			limpiarMatriz( tamanioTotalFilas, tamanioTotalColumnas);
			st = new StringTokenizer(bf.readLine());
			cLineas = Integer.parseInt(st.nextToken());
			numero = st.nextToken();
		}
	}


	private static void calcularFilCol( ) {
		fil = 0;
		col += c + 3;
	}

	public static void pintarBitHorizontal( int bit  ){
		int i=0;
		int j=0;
		switch(bit){
		case 1: i = fil; j = col+1; break;
		case 4: i = fil+c+1; j = col+1; break;
		case 7: i = (c*2)+2; j = col+1;break;
		default : return; 
		}

		for( int cont = 0 ; cont < c ; cont++ ){
			m[i][j++]='-';
		}
	}

	public static void pintarBitVertical( int bit ){
		int i , j;
		if( bit == 2 || bit == 3 ) i = fil+1;
		else  i = fil+c+2;
		if( bit == 2 || bit == 5 ) j = col ;
		else j = col + c + 1;

		for( int cont = 0 ; cont < c ; cont++){
			m[i++][j] = '|';
		}
		i = fil;
	}
	public static void limpiarMatriz( int fil , int col ){
		for(int i = 0 ; i < fil; i++)
			for (int j = 0; j < col; j++) 
				m[i][j]=' ';
	}
}
