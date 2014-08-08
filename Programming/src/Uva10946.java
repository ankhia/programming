import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Uva10946 {

	static int n[][];
	static char m[][];
	static boolean v[][];
	static ArrayList<int[]> array;
	static int dx[]={ 1 , -1 , 0 ,  0 };
	static int dy[]={ 0 ,  0 , 1 , -1 };
	public static void main(String[] args) throws Throwable
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int i = 1;
		for (String line ; (line = in.readLine())!=null; i++) {
			StringTokenizer st = new StringTokenizer(line);
			int f = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if( f== 0 && c == 0) break;
			sb.append("Problem "+i+":\n");
			
			m = new char[f][c];
			v = new boolean[f][c];
			array = new ArrayList<int[]>();
			for (int j = 0; j < f; j++) {
				line = in.readLine();
				m[j] = line.toCharArray();
			}
			
			for (int j = 0; j < m.length; j++) {
				for (int k = 0; k < m[j].length; k++) {
					if( !v[j][k] && m[j][k]!='.') {
						char key = m[j][k];
						int valor = floodfill( m[j][k], j, k );
						array.add(new int[]{(int)(key-'A'), valor});
					}
				}
			}
			
			Collections.sort(array , new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return o2[1]-o1[1] == 0 ? o1[0]-o2[0]: o2[1]-o1[1];
				}
			});
			
			for (int j = 0; j < array.size(); j++) {
				int[] r = array.get(j);
				sb.append((char)(r[0]+'A') +" "+ r[1]+"\n");
			}
			
		}			
		System.out.print(new String(sb));
	}
	
	public static int floodfill( char s , int i , int j ){
		Queue<Integer> x = new LinkedList<Integer>();
		Queue<Integer> y = new LinkedList<Integer>();
		
		x.add(i);
		y.add(j);
		int c = 1;
		v[i][j] = true;
		while(!x.isEmpty()){
			int xa = x.poll();
			int ya = y.poll();
			m[xa][ya] = '&';
			for (int k = 0; k < dx.length; k++) {
				int nx = xa+dx[k];
				int ny = ya+dy[k];
				if( nx >= 0 && nx < m.length && ny >= 0 && ny < m[nx].length && !v[nx][ny] && m[nx][ny] == s){
					x.add(nx);
					y.add(ny);
					c+=1;
					v[nx][ny] = true;
				}
			}
		}
		return c;
	}
}
