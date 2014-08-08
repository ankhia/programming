import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CodeForces34A {

	static int[]num;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		num = new int[n];
		for (int i = 0; i < n; i++) 
			num[i]=Integer.parseInt(st.nextToken());
		int min = Integer.MAX_VALUE;
		int a = -1;
		int b = -1;
		for (int i = 1; i < num.length; i++) {
			if( Math.abs(num[i]-num[i-1]) < min ){
				a = i;
				b = i+1;
				min = Math.abs(num[i]-num[i-1]);
			}
		}
		if(Math.abs(num[0]-num[num.length-1])<min){
			a = num.length;
			b = 1;
		}
		System.out.println(a+" "+b);
	}

}
