

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva11015 {

	static String[] members ;
	static double[][] mAdy;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int caso = 1;
		for ( String line; (line = in.readLine().trim()) != null; caso++) {
			StringTokenizer st = new StringTokenizer(line);
			int nodes = Integer.parseInt(st.nextToken());
			int paths = Integer.parseInt(st.nextToken());
			if(nodes == 0 && paths == 0) break;
			members = new String[nodes];
			for (int i = 0; i < nodes; i++) {
				members[i]=in.readLine().trim();
			}
			mAdy = new double[nodes][nodes];
			for (int i = 0; i < mAdy.length; i++) {
				for (int j = 0; j < mAdy[i].length; j++) {
					if(i==j) mAdy[i][j]=0;
					else mAdy[i][j]=Double.MAX_VALUE;
				}
			}
			for (int i = 0; i < paths; i++) {
				st = new StringTokenizer(in.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				mAdy[r-1][c-1] = v;
				mAdy[c-1][r-1] = v;
			}
			
			
			double[][] a = floydWarshall2(mAdy);
			double min = Double.MAX_VALUE;
			int casa = -1;
			for (int i = 0; i < a.length; i++) {
				double sume = 0;
				for (int j = 0; j < a[i].length; j++) {
					sume+=a[i][j];
				}
				if(sume<min) {
					min = sume;
					casa = i;
				}
			}
			
			sb.append("Case #"+caso+" : "+members[casa]+"\n");
		}
		System.out.print(new String(sb));
	}

	static double[][] floydWarshall(double[][] mAdy) { 
		int n=mAdy.length; double x[][]=new double[n][n]; 
		for (int i=0; i<n; i++) System.arraycopy(mAdy[i],0,x[i],0,n); 
		for (int k=0; k<n; k++) for (int i=0; i<n; i++) for (int j=0; j<n; j++) 
			x[i][j]=Math.min(x[i][j],x[i][k]+x[k][j]); 
		return x; 
	}
	static	double[][] floydWarshall2(double[][] mAdy){
		int N; double[][] res = new double[N=mAdy.length][N];
		for(int i=0;i<N;i++)for(int j=0;j<N;j++)res[i][j]=mAdy[i][j];
		for(int k=0;k<N;k++)
		for(int i=0;i<N;i++)
		for(int j=0;j<N;j++)
		if(res[i][k]<Double.MAX_VALUE&&res[k][j]<Double.MAX_VALUE)
		res[i][j]=Math.min(res[i][j],res[i][k]+res[k][j]);
		return res;
		}


}
