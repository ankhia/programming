import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CodeForcesEugenyAndArray {

	static int[] num;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		num = new int[n];
		int cantUnos = 0;
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			if(num[i]==1) cantUnos++;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if( (b-(a-1))%2==0 && ( (b-(a-1)) <= ( n - Math.abs((cantUnos-(n-cantUnos)))))){
				System.out.println("1");
			}else
				System.out.println("0");
		}
		
	}

}
