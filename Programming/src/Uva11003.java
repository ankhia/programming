
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/external/110/11003.html
 * @veredict Accepted 
 * @problemId 11003
 * @problemName  Boxes
 * @judge http://uva.onlinejudge.org/
 * @category DP
 * @level easy
 * @date 16/04/2012
 **/ 

public class Uva11003 {

	static int mem[][];
	static int matriz[][];
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cajas = Integer.parseInt(in.readLine());
		while( cajas!=0 ){ 
			matriz = new int[cajas][2];
			mem = new int[cajas][3001];
			for (int i = 0; i < mem.length; i++) {
				Arrays.fill(mem[i], -1);
			}
			
			for (int i = 0; i < cajas; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				matriz[i][0]= Integer.parseInt(st.nextToken());
				matriz[i][1]= Integer.parseInt(st.nextToken());
			}
			
			System.out.println(f( 0, Integer.MAX_VALUE ));
			cajas = Integer.parseInt(in.readLine());
		}
	}

	static int f( int i , int j ){
		if(j<0)return -100000;
		if( i == matriz.length ){
			return 0;
		}
		if(j<=3000 && mem[i][j]!=-1 )
			return mem[i][j];
//		else if( matriz[i][0] <= j )
		if(j<=3000)
			return mem[i][j] = Math.max(f(i+1, Math.min(j-matriz[i][0], matriz[i][1])) + 1 , f( i+1,j ) );
		return Math.max(f(i+1, Math.min(j-matriz[i][0], matriz[i][1])) + 1 , f( i+1,j ) );
			
	}
	
}
