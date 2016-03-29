import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class CodeForces339A {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String ln ; (ln = in.readLine())!=null ; ) {
			String[] sp = ln.split("\\+");
			int num[] = new int[sp.length];
			for (int i = 0; i < sp.length; i++)
				num[i]=Integer.parseInt(sp[i]);
			Arrays.sort(num);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < num.length; i++) {
				if(i>0) sb.append("+");
				sb.append(num[i]);
			}
			System.out.println(new String(sb));
		}
	}
}
