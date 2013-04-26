

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;


public class Acm2452 {

	static double p;
	static double q;
	static double[][] matriz;
	static BigInteger llamadosMat[][];

	public static void main(String[] args) throws Throwable {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		matriz = new double[1001][1001];
		llamadosMat = new BigInteger[1001][1001];
		llamados();
		inicializar();
		
		String linea;
		int N=-1,caso=0;
		while( (linea = in.readLine())!=null && N != 0 ){
			StringTokenizer st = new StringTokenizer(linea);
			p = Double.parseDouble(st.nextToken());
			q = 1-p;
			llenarDinamica();
			N = Integer.parseInt(st.nextToken());
			if( N!=0 ){
				if(caso++>0)System.out.println();
				for (int i = 0; i < N; i++) {
					st = new StringTokenizer(in.readLine());
					int h = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					
					NumberFormat nf = NumberFormat.getInstance(Locale.US);
					nf.setMaximumFractionDigits(5);
					nf.setMinimumFractionDigits(5);
					double a = matriz[h][y];
					System.out.println(nf.format(a));
					System.out.println(llamadosMat[h][y]);
				}
			}
			else
				break;
		}
	}
	
	private static void inicializar() {
		matriz[0][0]=-1;
		for (int i = 1; i < matriz.length; i++) 
			matriz[i][0]=0;
		for (int j = 1; j < matriz.length; j++) 
			matriz[0][j]=1;
	}
	private static void llamados( ){
		for (int i = 0; i < llamadosMat.length; i++) 
			llamadosMat[i][0]=BigInteger.ZERO;
		for (int j = 0; j < llamadosMat.length; j++) 
			llamadosMat[0][j]=BigInteger.ZERO;
		for (int i = 1; i < llamadosMat.length; i++) {
			for (int j = 1; j < llamadosMat[0].length; j++) {
				llamadosMat[i][j] = llamadosMat[i][j-1].add(llamadosMat[i-1][j]).add(BigInteger.valueOf(2));
			}
		}
		//llamadosMat[i][j-1]+llamadosMat[i][j-1]+2
//		for (int i = 0; i < 5; i++) {
//			System.out.println(Arrays.toString(llamadosMat[i]));
//		}
	}

	static void llenarDinamica(  ){
//		matriz[0][0]=-1;
//		for (int i = 1; i < matriz.length; i++) 
//			matriz[i][0]=0;
//		for (int j = 1; j < matriz.length; j++) 
//			matriz[0][j]=1;	
		for (int i = 1; i < matriz.length; i++) {
			for (int j = 1; j < matriz[0].length; j++) {
				matriz[i][j]=(double)((p*matriz[i-1][j])+(q*matriz[i][j-1]));
			}
		}
	}
	

//	static double P(int i, int j){
//		if( matriz[i][j] != -1) return matriz[i][j];
//		if(i==0){
//			matriz[i][j]=1;
//		}
//		else if( j==0 ){
//			matriz[i][j]=0;
//		}
//		else {
//			matriz[i][j]=p*P(i-1,j)+q*P(i,j-1);
//		}
//		return matriz[i][j];
//	}

}
