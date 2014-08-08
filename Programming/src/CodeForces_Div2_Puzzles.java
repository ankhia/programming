import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CodeForces_Div2_Puzzles {

	static int puzz[];
	static int m;
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		m = Integer.parseInt(st.nextToken());
		int puzzles = Integer.parseInt(st.nextToken());
		puzz = new int[puzzles];
		st = new StringTokenizer(in.readLine());
		for(int i = 0 ; i < puzzles; i++){
			puzz[i] = Integer.parseInt(st.nextToken()); 
		}
		Arrays.sort(puzz);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < puzz.length; i++) {
			if( i + m-1 < puzz.length )
				if( puzz[i+m-1] - puzz[i] < min )
					min = puzz[i+m-1] - puzz[i];
		}
		System.out.println(min);
	}
}
