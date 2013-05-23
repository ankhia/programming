import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Uva10336 {

	static char m[][];
	static boolean v[][];
	static int dx[]={-1,1,0,0};
	static int dy[]={ 0,0,1,-1};
	static TreeMap<Character, Integer> tree;
	static int[][]nM;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cas = Integer.parseInt(in.readLine());
		for (int t = 0; t < cas; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int f = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			m = new char[f][c];
			v = new boolean[f][c];
			tree = new TreeMap<Character, Integer>();
			
			for (int i = 0; i < m.length; i++) {
				String line = in.readLine();
				for (int j = 0; j < line.length(); j++) {
					m[i][j]=line.charAt(j);
				}
			}
			
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					if(!v[i][j]){
						if(tree.containsKey(m[i][j]))
							tree.put(m[i][j], tree.get(m[i][j])+1);
						else
							tree.put(m[i][j], 1);
						floodfill(i, j, m[i][j]);
					}
				}
			}
//			System.out.println(tree.toString());
			sb.append("World #"+(t+1)+"\n");
			//ORDENAR ESA VUELTA
			nM = new int[tree.size()][2];
		
//			System.out.println( (int) ('a' - 'a'));
			int j = 0;
			for (Character key : tree.keySet()) {
					nM[j][0] = (int)(key - 'a');
					nM[j][1] = tree.get(key);
					j++;
			}
//			System.out.println("-->");
//			for (int i = 0; i < nM.length; i++) {
//				for (int kj = 0; kj < nM[i].length; kj++) {
//					System.out.print(nM[i][kj]+" ");
//				}
//				System.out.println();
//			}
			
			Arrays.sort(nM, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return o2[1]-o1[1]==0?o1[0]-o2[0]:o2[1]-o1[1];
				}
			});
			
			//ITERAR ESA VUELTA
			
			for (int i = 0; i < nM.length; i++) {
				sb.append((char)(nM[i][0]+'a')+": "+nM[i][1]+"\n");
			}
			
			//IMPRIMIR ESA VUELTA
		}
		System.out.print(new String(sb));
	}

	public static void floodfill(int i, int j , char source){
		Queue<Integer> x = new LinkedList<Integer>();
		Queue<Integer> y = new LinkedList<Integer>();
		
		x.add(i);
		y.add(j);
		v[i][j]=true;
		while(!x.isEmpty()){
			int xa = x.poll();
			int ya = y.poll();
			m[xa][ya]='&';
			for (int k = 0; k < dx.length; k++) {
				int nx = xa+dx[k];
				int ny = ya+dy[k];
				if( nx >= 0 && nx < m.length && ny >=0 && ny < m[nx].length && !v[nx][ny] && m[nx][ny]!='&' && m[nx][ny]==source){
					x.add(nx);
					y.add(ny);
					v[nx][ny] = true;
				}
			}
		}
	}
}
