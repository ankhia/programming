

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Uva12516 {

	static int [][] mat;
	static int [][] ami;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for ( String linea; ( linea = in.readLine( ) ) != null; ) {
			StringTokenizer st = new StringTokenizer(linea);
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			if( R==0 && C==0 ) break;

			mat = new int[R][C];

			int P = Integer.parseInt(in.readLine());
			for (int p = 0; p < P; p++) {
				StringTokenizer st2 = new StringTokenizer( in.readLine() );
				String a = st2.nextToken();
				int i = (int)((a.charAt(0))-65);
				int j = Integer.parseInt(a.substring(1))-1;
				int d = st2.nextToken().equals("+")?1:-1;
				mat[i][j] = d;
			}
			
			boolean logre = true;
			int Z = Integer.parseInt(in.readLine());
			ami = new int[Z][2];
			for (int i = 0; i < Z; i++) {
				String dato = in.readLine();
				int r = (int)((dato.charAt(0))-65);
				dato = dato.substring(1);
				int c = (Integer.parseInt(dato))-1;
				ami[i][0]= r;
				ami[i][1]= c;

			}
			
			Arrays.sort(ami, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return (o1[0]-o2[0]==0)?o1[1]-o2[1]:o1[0]-o2[0];
				}
			});
			
			for (int am = 0; am < Z; am++) {
				if( logre ){
					int i = ami[am][0]; int j =ami[am][1];
					if( (j-1) >= 0 ){
						if( mat[i][j-1] == -1 ||  mat[i][j-1] == 0 )
							mat[i][j] = -1;
						else if( (j+1) < C ){
							if( mat[i][j+1] == 1 || mat[i][j+1] == 0)
								mat[i][j]=1;
							else{
								logre = false;
							}
						}else{
							mat[i][j] = 1;
						}
					}else{
						mat[i][j] = -1;
					}
				}
			}
			if( logre ){
				sb.append("YES\n");
			}else
				sb.append("NO\n");
		}
		System.out.print(new String(sb));
	}

//	public static int[] darNumeroFilaColumna( String dato ){
//		int r = (int)((dato.charAt(0))-65);
//		dato = dato.substring(1);
//		if( dato.split(" ").length > 1 ){
//			int c = (Integer.parseInt(dato.split(" ")[0]))-1;
//			int d = (dato.split(" ")[1].equals("-")) ? -1:1;
//			return new int[]{r, c, d};
//		}else{
//			int c = (Integer.parseInt(dato))-1;
//			return new int[]{r,c};
//		}
//
//	}
	
//	static void imprimir () {
//		for (int i = 0; i < mat.length; i++) {
//			for (int j = 0; j < mat[0].length; j++) {
//				System.out.print(mat[i][j]+" ");
//			}
//			System.out.println();
//		}
//	}

}
