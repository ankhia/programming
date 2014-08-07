import java.io.IOException;
import java.util.Scanner;

public class Uva907 {
	static int mem[][];
	static int a[];
	static int b[];
	static int sum[][];

	public static void main(String args[])throws IOException {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			a = new int[N + 1];
			b = new int[N + 1];
			for(int i = 0; i < (N + 1); i ++) {
				a[i] = sc.nextInt();
			}
			sum = new int[N + 1][N + 1];
			mem = new int[N + 1][K + 1];
			for (int i = 0; i < (N + 1); i ++) {
				for(int j = 0; j < (K + 1); j ++) {
					mem[i][j] = -1;
				}
			}
			for(int i = N; i >= 0; i --) {
				b[i] = a[N - i];
			}
			for(int i = 0; i < N + 1; i ++) {
				int sum = 0;
				for(int j = 0; j <= i; j ++) {
					sum = sum + b[j]; 
				}
				mem[i][0] = sum;
			}
			for(int i = 1; i < (K + 1); i ++) {
				mem[0][i] = b[0];
			}
			for(int i = 0; i < (N + 1); i ++) {
				for(int j = i - 1; j >= 0; j --) {
					int s = 0;
					for(int k = i; k > j; k --) {
						s = s + b[k];
					}
					sum[i][j] = s;
				}
			}
			System.out.println(DP(N, K));
		}
	}

	public static int DP(int n, int k) {
		if (mem[n][k] != -1)
			return mem[n][k];
		else {
			int min = Integer.MAX_VALUE/2;
			for(int i = n - 1; i >= 0; i --) {
				int temp = Math.max(sum[n][i], DP(i, k - 1));
				if(temp < min)
					min = temp;
			}
			mem[n][k] = min;
			return mem[n][k];
		}
	}
}
