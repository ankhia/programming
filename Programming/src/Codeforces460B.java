import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Codeforces460B {

	public static void main(String[] args) throws Throwable {
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		TreeSet<Long> solutions = new TreeSet<Long>();
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 81; i++) {
			long x = (long) ((b * Math.pow(i, a)) + c);
			if( sumDigits(x) == i && x < 1000000000 && x > 0)
				solutions.add(x);
		}
		System.out.println(solutions.size());
		int i = 0;
		for (Long u : solutions) {
			if( i > 0 )
				System.out.print(" ");
			System.out.print(u);
			i++;
		}
	}
	
	public static long sumDigits( long num ){
		if(num < 0) num*=-1;
		String a = num+"";
		long sum = 0;
		for (int i = 0; i < a.length(); i++) {
			sum+=Integer.parseInt(a.charAt(i)+"");
		}
		return sum;
	}
	
}
