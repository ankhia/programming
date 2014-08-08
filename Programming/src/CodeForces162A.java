import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CodeForces162A {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		if(n%2==0&&n!=2)System.out.println("YES");
		else System.out.println("NO");
	}

}
