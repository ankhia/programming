import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;


public class CodeForces236A {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln ; (ln = in.readLine())!=null; ){
			Set<Character> set = new TreeSet<Character>();
			for (int i = 0; i < ln.length(); i++) {
				set.add(ln.charAt(i));
			}
			if(set.size()%2!=0) System.out.println("IGNORE HIM!");
			else System.out.println("CHAT WITH HER!");
		}
	}
}
