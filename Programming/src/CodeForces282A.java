import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CodeForces282A {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String line; (line=in.readLine())!=null; ){
			int n = Integer.parseInt(line);
			int x = 0;
			for(int i = 0; i<n ; i++){
				String ln = in.readLine();
				if(ln.contains("+"))
					x++;
				else
					x--;
			}
			System.out.println(x);
		}
	}
}
