import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CodeForces275B {

	static char ma[][];
	static int row[][];
	static int col[][];
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ma = new char[n][m];
		row = new int[n][m];
		col = new int[n][m];
		for (int i = 0; i < n; i++) {
			ma[i] = in.readLine().toCharArray();
		}
		
		int cont = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(ma[i][j]=='B'){
					row[i][j] = cont;
				}else{
					cont++;
				}
			}	
		}
		cont = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(ma[j][i]=='B'){
					col[j][i] = cont;
				}else{
					cont++;
				}
			}	
		}
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(row[i]));
//		}
//		System.out.println();
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(col[i]));
//		}
		boolean si = true;
		for (int i = 0; i < n && si; i++) {
			for (int j = 0; j < m && si; j++) {

				for (int k = 0; k < n && si; k++) {
					for (int l = 0; l < m && si; l++) {
						if( !(i==k && j==l) && ma[i][j]=='B' && ma[k][l]=='B' ){
							if( i == k ){
								if( row[i][j] != row[k][l]){
									si = false;
//									System.out.println("cc");
								}
									
							}else if( j == l ){
								if( col[i][j] != col[k][l]){
									si = false;
//									System.out.println("bb");
								}
									
							}else{
								int x1,y1;
								int x2,y2;
								int xu,yu;
								int xd,yd;
								if( i < k ) {
									x1 = i; y1 = j;	x2 = k; y2 = l; xu = i; xd = k; yu = l; yd = j;
								}else{
									x1 = k; y1 = l; x2 = i; y2 = j; xu = k; xd = i;yu = j; yd = l;
								}
//								if( i == 1 && j == 3)
//								System.out.println(i+" "+j+" * " + k+" "+l+" * " + xu +" "+yu+" * "+xd+" "+yd);
								if( !( row[xu][yu] == row[x1][y1] && col[xu][yu] == col[x2][y2] ) && 
										!( row[xd][yd] == row[x2][y2] && col[xd][yd]==col[x1][y1] ) ) {
//									System.out.println( "aa ");
									si = false;
								}
							}
						}
					}
				}
			
			}
		}
		if(si) System.out.println("YES");
		else System.out.println("NO");
		
	}

}
