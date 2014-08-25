import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;


public class Uva10424 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(String ln ; (ln = in.readLine())!= null; ){
			int name1 = value(ln.trim());
			int name2 = value(in.readLine().trim());
			while(name1 > 9)
				name1 = sumDigits(name1);
			while(name2 > 9)
				name2 = sumDigits(name2);
			sb.append(String.format(Locale.US, "%.2f", ratio(name1, name2))).append(" %").append("\n");
		}
		System.out.print(new String(sb));
	}
	
	static double ratio(int a , int b ){
		double div = (double)( (double)Math.min(a, b)/ (double)Math.max(a, b));
		return (div*100.);
	}
	
	static int sumDigits( int n ){
		String a = n+"";
		int sum = 0;
		for (int i = 0; i < a.length(); i++) {
			sum += Integer.parseInt(a.charAt(i)+"");
		}
		return sum;
	}
	
	static int value( String  pal ){
		int sum = 0;
		pal = pal.toLowerCase();
		for (int i = 0; i < pal.length(); i++) {
			if(Character.isLetter(pal.charAt(i)))
				sum+=((int)pal.charAt(i))-96;
		}
		return sum;
	}

}
