

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.Bidi;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author Angie Milena Vega Leon
 * @veredict -- 
 * @problemId 
 * @problemName  Robots on a grid
 * @judge Boca
 * @category DP , BFS
 * @level --
 * @date 26/07/2012
 **/
public class robots {

	static char m[][];
	static BigInteger mem[][];

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
		StringBuilder sb = new StringBuilder( );
		for (int n; ( n = Integer.parseInt( in.readLine( ) ) ) != 0; ) {
			m = new char[n][n];
			mem = new BigInteger[n][n];
			for (int i = 0; i < n; i++) {
				m[i] = in.readLine().toCharArray();
			}

			BigInteger caminos = f(0, 0).mod(BigInteger.valueOf(Integer.MAX_VALUE));
			if( caminos.compareTo(BigInteger.ZERO) == 0 ){
				if(bfs())
					sb.append("THE GAME IS A LIE");
				else
					sb.append("INCONCEIVABLE");
			}else
				sb.append(caminos);
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}

	private static BigInteger f(int i, int j) {
		if( i >= m.length || j >= m.length ) 
			return BigInteger.ZERO;
		if(mem[i][j] != null ) 
			return mem[i][j];
		if( m[i][j] == '#' ) 
			return mem[i][j] = BigInteger.ZERO;
		if( i == m.length-1 && j == m.length-1 ){
			return (m[i][j] == '#') ? (mem[i][j] = BigInteger.ZERO): (mem[i][j] = BigInteger.ONE) ;
		}
		return mem[i][j] = f(i+1,j).add(f(i,j+1));
	}

	private static boolean bfs( ){

		boolean llega = false;
		Stack<Integer> f = new Stack<Integer>();
		Stack<Integer> c = new Stack<Integer>();
		int tam = m.length;
		boolean [][] visitados = new boolean[tam][tam];
		f.push(0);
		c.push(0);
//		visitados[0][0] = true;
		while(!f.isEmpty() && !llega){
			int fila = f.pop();
			int columna = c.pop();

			if(fila == tam-1 && columna == tam-1 && m[fila][columna] != '#')
				llega = true;

			if( (fila+1) < tam && columna < tam && !visitados[fila+1][columna] && m[fila+1][columna] != '#'){
				f.push(fila+1);c.push(columna);
//				visitados[fila+1][columna] = true;
			}
			if( fila < tam && (columna+1) < tam && !visitados[fila][columna+1] && m[fila][columna+1] != '#'){
				f.push(fila);c.push(columna+1);
//				visitados[fila][columna+1] = true;
			}
			if( (fila-1) >= 0 && columna < tam && !visitados[fila-1][columna] && m[fila-1][columna] != '#'){
				f.push(fila-1);c.push(columna);
//				visitados[fila-1][columna] = true;
			}
			if( fila < tam && (columna-1) >= 0  && !visitados[fila][columna-1] && m[fila][columna-1] != '#'){
				f.push(fila);c.push(columna-1);
//				visitados[fila][columna-1] = true;
			}
			visitados[fila][columna] = true;
		}
		return llega;
	}
}
