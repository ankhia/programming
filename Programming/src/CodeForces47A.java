import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CodeForces47A {

	static boolean[] t;
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		t = new boolean[501];
		t[0]=false;
		t[1]=true;
		for (int i = 2; ((i *(i+1))/2) < t.length; i++) {
			t[(i *(i+1))/2]=true;
		}
		int n = Integer.parseInt(in.readLine());
		System.out.println(t[n]?"YES":"NO");
	}

}
