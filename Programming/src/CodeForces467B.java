import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CodeForces467B {

	static String[] numbers;
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		numbers = new String[m+1];
		for (int i = 0; i < (m+1); i++) {
			int a = Integer.parseInt(in.readLine());
			StringBuilder sb = new StringBuilder();
			numbers[i] = Integer.toBinaryString(a); 
			if(numbers[i].length()<n)
				for (int j = 0; j < (n - numbers[i].length()); j++) 
					sb.append("0");
			numbers[i] = new String(sb.append(numbers[i]));
		}
		String fedor = numbers[m];
		int cantAmigos = 0;
		for (int i = 0; i < numbers.length-1; i++) {
			int cantDiffer = 0;
			for (int j = 0; j < n; j++) {
				if( fedor.charAt(j) != numbers[i].charAt(j) )
					cantDiffer++;
			}
			if(cantDiffer <= k)
				cantAmigos++;
		}
		System.out.println(cantAmigos);
	}

}
