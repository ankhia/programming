

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Uva469 {

	static int dx[] = new int[]{ -1,  0,  1, -1, 1, -1, 0, 1};
	static int dy[] = new int[]{ -1, -1, -1,  0, 0,  1, 1, 1};

	static ArrayList<String> lineas;
	static char m[][] ;
	static boolean  [][]mC;
	
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
		StringBuilder sb = new StringBuilder( );
		int casos = Integer.parseInt( in.readLine( ) );
		in.readLine( );
		for (int t = 0; t < casos; t++) {
			lineas = new ArrayList<String>();
			for (String line; (line = in.readLine( )) != null && !line.equals(""); ) {
				StringTokenizer st = new StringTokenizer( line );
				if(st.countTokens() > 1 ){
					m = new char[lineas.size()][lineas.get(0).length()];
					mC = new boolean[lineas.size()][lineas.get(0).length()];
					for(int i = 0; i < lineas.size(); i++) {
						String liniesita = lineas.get(i);
						for (int j = 0; j < liniesita.length(); j++) {
							m[i][j] =  liniesita.charAt(j);
						}
					}

					int i = Integer.parseInt(st.nextToken()); 
					int j = Integer.parseInt(st.nextToken());
					
					sb.append( floodfill(i-1, j-1) +"\n") ;
				}else{
					lineas.add(line);
				}
			}
			if( t < casos-1 ){
				sb.append("\n");
			}
		}
		System.out.print(new String(sb));
	}

	public static int floodfill( int i, int j  ){
		int finish = 0;
		Queue<Integer> x1 = new LinkedList<Integer>();
		Queue<Integer> y1 = new LinkedList<Integer>();
		if( m[i][j] != 'W')
			return 0;
		else{
			x1.add( i );
			y1.add( j );
			mC[i][j] = true;
			while( !x1.isEmpty() ){
				int x = x1.poll();
				int y = y1.poll();

				if( m[x][y] == 'W' ){
					finish += 1;
				}
				for (int k = 0; k < dx.length; k++) {
					int f = x+dx[k];
					int c = y+dy[k];
					if(  f >= 0 && c >=0 && f < m.length && c < m[0].length && m[f][c]=='W' && !mC[f][c]){
						x1.add(f);
						y1.add(c);
						mC[f][c] = true;
					}
				}
			}
		}
		return finish;
	}


}
