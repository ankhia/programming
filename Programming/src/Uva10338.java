import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Set;


public class Uva10338 {

	static BigInteger b[ ] = new BigInteger[ 21 ];
	static HashMap<Character, Integer> h ;
	public static void main(String[] args) throws Throwable {
		StringBuilder sb = new StringBuilder();
		b[0] = BigInteger.ZERO;
		b[1] = BigInteger.ONE;
		for (int i = 2; i < b.length; i++) 
			b[i] = b[i-1].multiply( BigInteger.valueOf( i ) );
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for (int test = 0; test < t; test++) {
			
			
			h = new HashMap<Character, Integer>();
			String line = in.readLine();
			for (int i = 0; i < line.length(); i++) {
				char act = line.charAt(i);
				if(h.get(act)==null){
					h.put(act, 1);
				}else{
					h.put(act, h.get(act)+1);
				}
			}
			
			Set<Character> s = h.keySet();
			
			BigInteger res  = b[line.length()];
			
			BigInteger mul = BigInteger.ONE;
			for (Character a : s) {
				if(h.get(a)>1){
					mul=mul.multiply(b[h.get(a)]);
				}
			}
			
			res = res.divide(mul);
			sb.append("Data set "+(test+1)+": "+res+"\n");
		}
		System.out.print(new String(sb));
	}
}
