import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CodeForces281A {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln; (ln = in.readLine())!=null; ){
			ln = Character.toUpperCase(ln.charAt(0)) + ln.substring(1);
			System.out.println(ln);
		}
	}
}
