import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class haunted {

	static double[][]mAdy;
	static ArrayList<Integer>[] lAdy;
	static boolean [] isWall;
	static boolean [] isHole;
	static int dx[] = {0 ,  0 , -1 ,  1};
	static int dy[] = {1 , -1 ,  0 ,  0};
	static int W;
	static int H;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Throwable {
		StringBuilder sb = new StringBuilder( );
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String line; (line = in.readLine())!=null;) {
			StringTokenizer st = new StringTokenizer(line);
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if(W==0&&H==0)break;

			isWall = new boolean[W*H];
			isHole = new boolean[W*H];

			lAdy = new ArrayList[W*H];
			mAdy = new double[W*H][W*H];
			for (int i = 0; i < mAdy.length; i++) {
				Arrays.fill(mAdy[i], Double.POSITIVE_INFINITY);
				mAdy[i][i] = 0;
			}

			int cGrav = Integer.parseInt(in.readLine());
			for (int i = 0; i < cGrav; i++) {
				st = new StringTokenizer( in.readLine() );
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				isWall[pos(x, y)] = true;
			}

//			System.out.println(Arrays.toString(isWall));
			int cHauted = Integer.parseInt(in.readLine());
			for (int i = 0; i < cHauted; i++) {
				st = new StringTokenizer(in.readLine());
				int fromX = Integer.parseInt(st.nextToken());
				int fromY = Integer.parseInt(st.nextToken());
				int toX = Integer.parseInt(st.nextToken());
				int toY = Integer.parseInt(st.nextToken());
				int posFrom = pos(fromX, fromY); 
				int posTo = pos(toX, toY);
				isHole[posFrom] = true;
				mAdy[posFrom][posTo] = Integer.parseInt(st.nextToken());
				ArrayList<Integer> h = new ArrayList<Integer>();
				h.add(posTo);
				lAdy[posFrom] = h; 
			}

			for (int i = 0; i < W; i++) {
				for (int j = 0; j < H; j++) {
					int posFrom = pos(i, j);
					if(lAdy[posFrom]==null)
						lAdy[posFrom]= new ArrayList<Integer>();
					if(i == W-1 && j== H-1) break;
					for (int k = 0; k < dx.length; k++) {
						int x = i+dx[k];
						int y = j+dy[k];
						int posTo = pos(x, y);
						if( x >= 0 && x < W && y >= 0 && y < H && !isWall[posFrom] && !isWall[posTo] && !isHole[posFrom]){
							mAdy[posFrom][posTo] = 1;
							ArrayList<Integer> list = lAdy[posFrom];
							list.add(posTo);
							lAdy[posFrom] = list;

						}
					}
				}
			}

			double[] solBel = bellmanFord(mAdy, lAdy, 0);
			if(solBel == null)
				sb.append("Never");
			else if( solBel[solBel.length-1]==Double.POSITIVE_INFINITY )
				sb.append("Impossible");
			else sb.append((int)solBel[solBel.length-1]);
			sb.append("\n");

		}
		System.out.print(new String(sb));
	}

	static int pos(int i , int j){
		return i * H + j;
	}

	static double[] bellmanFord(double[][] mAdy, ArrayList<Integer> lAdy[], int v) { 
		int n=mAdy.length; double[] mins=new double[n]; 
		Arrays.fill(mins,Double.POSITIVE_INFINITY); mins[v]=0d; 
		for (int k=1; k<n; k++) 
			for (int i=0; i<n; i++) 
				for (int j:lAdy[i]) 
					mins[j]=Math.min(mins[j],mins[i]+mAdy[i][j]);
		for (int i=0; i<n; i++) for (int j:lAdy[i]) 
			if (mins[j]>mins[i]+mAdy[i][j]+1e-10) return null; // Ciclo de peso negativo 
		return mins; 
	} 
}
