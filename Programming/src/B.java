import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class B {

	static int num[];
	static int[] sum;
	static int k;
	static int mem [][];
	
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		num = new int[n];
		sum = new int[n];
		mem = new int[n][n];
		for (int i = 0; i < mem.length; i++) {
			Arrays.fill(mem[i], -1);
		}
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			if(i-1 >= 0)
				sum[i] = num[i]+sum[i-1];
			else sum[i]=num[i];
		}
		int max = f( 0,k );
		boolean chimbito = false;
		for (int i = 0; i < mem.length && !chimbito; i++) {
			System.out.println(Arrays.toString(mem[i]));
			for (int j = 0; j < mem[i].length && !chimbito; j++) {
				if( mem[i][j]==max){
					sb.append((i+1)+" "+(j+1)+"\n");
					chimbito = true;
				}
			}
		}
		
		System.out.print(new String(sb));
	}

	static int f( int i, int j ){
		
		if( i >= num.length || j>=num.length || (j+k-1)>=num.length || (i+k-1) >= num.length){
			return 0;
		}else if( mem[i][j] != -1 ) return mem[i][j];
		else{
		int resta = 0;
			if( i> 0 )
				resta = sum[i-1] ;
			return mem[i][j] = Math.max( (sum[i+k-1] - resta )+ ( sum[j+k-1] - sum[ j-1 ] ), Math.max(f( i,j+1 ), f( i+1,j+1 )));
		}
	}
}
