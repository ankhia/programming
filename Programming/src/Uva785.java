import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Uva785 {

	static ArrayList<char[]> array;
	static char[][] m ;
	static int dx[] = { -1,0,0,1 };
	static int dy[] = { 0,-1,1,0 };
	static boolean visitados[][];
	public static void main(String[] args) throws Throwable {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		array = new ArrayList<char[]>();
		for (String line;(line = in.readLine())!=null; ) {
			if( line.contains("_") ) {
				m = new char[array.size()][];
				visitados = new boolean[array.size()][];
				for (int i = 0; i < array.size(); i++){ 
					m[i] = array.get(i);
					visitados[i] = new boolean[m[i].length]; 
				}
				
				for (int i = 0; i < m.length; i++) {
					for (int j = 0; j < m[i].length; j++) {
						if( m[i][j]!='X' && m[i][j]!=' ' && !visitados[i][j]){
							floodFill(i, j, m[i][j]);
						}
					}
				}
				
				for (int i = 0; i < m.length; i++) {
					for (int j = 0; j < m[i].length; j++) {
						sb.append(m[i][j]);
					}
					sb.append("\n");
				}
				sb.append(line+"\n");				
				array = new ArrayList<char[]>();
			}else{
				array.add(line.toCharArray());
			}
		}
		System.out.print(new String(sb));
	}
	
	static void floodFill( int i,int j, char targetColor  ){
		Queue<Integer> posX = new LinkedList<Integer>();
		Queue<Integer> posY = new LinkedList<Integer>();
		posX.add(i);
		posY.add(j);
		visitados[i][j] = true;
		while(!posX.isEmpty()){
			int x = posX.poll();
			int y = posY.poll();
			for (int k = 0; k < dx.length; k++) {
				int nX = x+dx[k];
				int nY = y+dy[k];
				if( nX >= 0 && nX < m.length && nY >= 0 && nY < m[nX].length && m[nX][nY] != 'X' && !visitados[nX][nY]){
					m[nX][nY] = targetColor;
					posX.add(nX);
					posY.add(nY);
					visitados[nX][nY] = true;
				}
			}
		}
	}
	
}
