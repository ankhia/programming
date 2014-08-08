import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class LA5682 {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < n; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int c =  Integer.parseInt(st.nextToken());
			int[] v = new int[c];
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < c; i++) {
				v[i] = Integer.parseInt(st.nextToken());
				min = Math.min(min, v[i]);
				max = Math.max(max, v[i]);
			}
			Arrays.sort(v);
			int largest = Integer.MIN_VALUE;
			for (int i = 1; i < v.length; i++) {
				largest = Math.max(largest, v[i]-v[i-1]);
			}
			System.out.println("Class "+(tc+1));
			System.out.println("Max "+max+", Min "+min+", Largest gap "+largest);
		}
	}

}
