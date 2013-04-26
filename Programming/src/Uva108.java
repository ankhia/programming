
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=44
 * @veredict Accepted 
 * @problemId 108
 * @problemName  Maximum Sum
 * @judge http://uva.onlinejudge.org/
 * @category DP
 * @level easy
 * @date 26/03/2011
 **/ 

public class Uva108 {

	static int[][] array;
	static int mem[][];
	static int n;
	static int mayor;
	public static void main(String[] args) throws Throwable {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String linea ;
		while( (linea=bf.readLine())!=null ){
			n = Integer.parseInt(linea);	
			array = new int[n][n];
			mem = new int[n][n];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(st.hasMoreTokens()){
						array[i][j]=Integer.parseInt(st.nextToken());
					}
					else{
						st = new StringTokenizer(bf.readLine());
						array[i][j] = Integer.parseInt(st.nextToken());
					}
				}
			}
			llenarMem();
			mayor();
			System.out.println(mayor);
		}
	}
	
	public static void mayor( ){
		mayor = Integer.MIN_VALUE;
		for (int i = 0; i < mem.length; i++) {
			for (int j = 0; j < mem[0].length; j++) {
				for (int j2 = i; j2 < mem.length; j2++) {
					for (int k = j; k < mem[0].length; k++) {
						int ret = D(i,j,j2,k);
						if(ret>mayor)
							mayor = ret;
					}
				}
			}
		}
	}
	
	public static int D(int a, int b, int i, int j ){
		
		if(a==0 && b==0)
			return mem[i][j];
		if(a==0)
			return mem[i][j] - mem[i][b-1];
		if(b==0)
			return mem[i][j] - mem[a-1][j];
		
		return mem[i][j] - mem[i][b-1] - mem[a-1][j] + mem[a-1][b-1];
	}
	

//	public static void imprimir() {
//		
//		System.out.println("=================ARRAY================");
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(array[i]));
//		}
//		System.out.println("=================MEMOR================");
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(mem[i]));
//		}
//		System.out.println("========================================");
//		System.out.println("El mayor es" + mayor);
//	}
	
	private static void llenarMem() {
		mem[0][0] = array[0][0];
		for (int i = 1; i < n; i++) {
			mem[i][0] = mem[i-1][0] + array[i][0];
		}
		for (int j = 1; j < n; j++) {
			mem[0][j] = mem[0][j-1] + array[0][j];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				mem[i][j] = array[i][j] + mem[i-1][j] + mem[i][j-1] - mem[i-1][j-1];
			}
		}
	}
}
