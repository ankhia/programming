import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestCodility {
	
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		int []A = new int[]{2147483647, 7,2147483647}; 
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		int[] sums = new int[A.length];
		if( A.length > 0 )
		sums[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			sums[i] = A[i]+sums[i-1];
		}
		
		int sol = -1;
		boolean found = false;
		for (int i = 0; i < sums.length && !found; i++) {
			
			int a = (i-1>=0)?sums[i-1]:0;
			int b = (i+1<A.length)?sums[A.length-1]-sums[i]:0;

			if( a == b ){
				sol = i;
				found = true;
			}
		}
		return sol;
		
	}
	
}
