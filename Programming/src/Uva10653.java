

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Uva10653 {

	static int []dx = new int[]{ -1, 0, 0, 1 };
	static int []dy = new int[]{ 0, -1, 1, 0 };
	
	static boolean[][]m;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String linea; (linea=in.readLine())!=null ; ) {
			StringTokenizer st = new StringTokenizer(linea);
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(r==0 && c==0) break;
			m=new boolean[r][c];
			int rBombs =  Integer.parseInt(in.readLine());
			for (int i = 0; i < rBombs; i++) {
				st = new StringTokenizer(in.readLine());
				int row =  Integer.parseInt(st.nextToken());
				int cantBombsRow = Integer.parseInt(st.nextToken());
				while(cantBombsRow-->0){
					int col = Integer.parseInt(st.nextToken());
					m[row][col]=true;
				}
			}
			st = new StringTokenizer(in.readLine());
			int xS = Integer.parseInt(st.nextToken());
			int yS = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			int xG = Integer.parseInt(st.nextToken());
			int yG = Integer.parseInt(st.nextToken());

			int finish = -1;
			Queue<Integer> x = new LinkedList<Integer>();
			Queue<Integer> y = new LinkedList<Integer>();
			Queue<Integer> cont = new LinkedList<Integer>();
			
			x.add(xS);
			y.add(yS);
			cont.add(0);
			while (!x.isEmpty() ) {
				int xA = x.poll();
				int yA = y.poll();
				int cuenta = cont.poll();
				
				if(xA == xG && yA == yG){
					finish = cuenta;
					break;
				}
				for (int i = 0; i < dx.length; i++) {
					if( xA+dx[i] >=0 && yA+dy[i]>=0 &&  xA+dx[i] < r && yA+dy[i] < c  ){
						if( !m[(xA+dx[i])][(yA+dy[i])] ){
							m[xA+dx[i]][yA+dy[i]] = true;
							x.add((xA+dx[i]));
							y.add((yA+dy[i]));
							cont.add(cuenta+1);
						}
					}
				}
			}
			
			System.out.println(finish);
		}
	}
	
	static void imprimir( )
	{
		for (int i = 0; i < m.length; i++) {
			System.out.println(Arrays.toString(m[i]));
			
		}
	}
	
	static void bfs( ){
		Queue<Integer> cola = new LinkedList<Integer>();
		
	}

}
