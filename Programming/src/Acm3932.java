

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://livearchive.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=294&page=show_problem&problem=1933
 * @veredict Accepted 
 * @problemId 3932
 * @problemName  Finding Seats
 * @judge http://uva.onlinejudge.org/
 * @category DP
 * @level Hard
 * @date 10/01/2012
 **/

public class Acm3932 {

	static char matriz[][];
	static int K ;
	static int memorizacion2 [][];
	public static void main(String[] args) throws Throwable {
		
//		BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("find.in")));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for(String linea = bf.readLine(); !linea.equals("0 0 0");linea=bf.readLine()){
			
			
			String []nL = linea.split(" ");
			int R = Integer.parseInt(nL[0]);
			int C = Integer.parseInt(nL[1]);
			K = Integer.parseInt(nL[2]);
			matriz = new char[R][C];
			for(int i = 0 ; i < R ; i++){
					matriz[i] = bf.readLine().toCharArray();  
			}
			memorizacion2 = new int[R+1][C+1];
			llenarMemorizacion2();
			
			int menor = Integer.MAX_VALUE;
			for(int i=0; i<R; i++){
				for(int j=0; j<C; ++j){
					int aux = min(i, j, R-1, j); 
					if(aux<menor)
						menor=aux;
				}
			}
			System.out.println(menor);
		}
	}
	
	public static void llenarMemorizacion2() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				int cuento = (matriz[i][j]=='.'? 1:0 );
				if(i==0 && j==0)
					memorizacion2[i][j] = cuento;
				else if(i==0)
					memorizacion2[i][j] = memorizacion2[i][j-1] + cuento;
				else if(j==0)
					memorizacion2[i][j] = memorizacion2[i-1][j] + cuento;
				else
					memorizacion2[i][j] = memorizacion2[i-1][j]+memorizacion2[i][j-1]-memorizacion2[i-1][j-1]+cuento;
			}
		}
	}

	
	public static int D(int a,int b,int i,int j){
		
		if( a == 0 && b == 0 ){
			if(memorizacion2[i][j]!=-1)
				return memorizacion2[i][j];
			else{
				memorizacion2[i][j]= c(i,j);
				return memorizacion2[i][j];
			}
		}
		else if( a==0 )			
			return c(i,j)-c(i,b-1);
		else if(b==0)
			return c(i,j)-c(a-1,j);	
		return c(i,j)-c(a-1,j)-c(i,b-1)+c(a-1,b-1);
	}
	
	static int min(int a, int b, int c, int d){
		if(d==matriz[0].length)return Integer.MAX_VALUE;
        if(c<a)return Integer.MAX_VALUE;
        if(D(a,b,c,d)>=K)return Math.min((c-a+1)*(d-b+1),min(a,b,c-1,d));
        return min(a,b,c,d+1);
	}
	
	public static int c(int i, int j){
			return memorizacion2[i][j];
// RECURSIVA
//		int cuento = (matriz[i][j]=='.') ? 1:0;
//		if(i==0 && j!=0){
//			memorizacion[i][j]= c(i,j-1) + cuento;
//			return memorizacion[i][j];
//		}else if(i!=0 &&j==0){
//			memorizacion[i][j]= c(i-1,j) + cuento;
//			return memorizacion[i][j];
//		}else if(i==0 && j==0){
//			memorizacion[i][j] = cuento;
//			return memorizacion[i][j];
//		}else{
//			memorizacion[i][j]=c(i-1,j)+c(i,j-1)-c(i-1,j-1) + cuento;
//			return memorizacion[i][j];
//		}
	}
}
