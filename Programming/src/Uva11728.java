
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Uva11728 {
	
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int a = 1;
		for (String line; (line=in.readLine())!= null ; a++ ) {
			int s = Integer.parseInt(line);
			if(s == 0) break;
			sb.append("Case "+a+": ");
			boolean encontre = false;
			for (int i = s; i >= 0 && !encontre ; i--) {
				List<Integer> factores = primeFactors(i);
				long respuesta = sumarFactores(factores, s); 
				if( respuesta == s ){
					sb.append(i+"\n");
					encontre = true;
				}
			}
			if(!encontre)
				sb.append("-1\n");
		}
		System.out.print(new String(sb));
	}
	
	public static long sumarFactores( List< Integer > factors, int s ){
		long sum = 0;
		boolean siga = true;
		for (int i = 0; i < factors.size() && siga ; i++) {
			sum+=factors.get(i);
			if(sum>s)siga = false;
		}
		return sum;
	}
	
	public static List<Integer> primeFactors(int numbers) {
	    int n = numbers;
	    List<Integer> factors = new ArrayList<Integer>();
	    for (int i = 1; i <= n ; i++) {
	      if (n % i == 0) {
	        factors.add(i);
	      }
	    }
	    return factors;
	  }
}
