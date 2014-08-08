import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Acm6161 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(in.readLine());
		for (int i = 0; i < cases; i++) {
			String line = in.readLine();
			if(line.charAt(line.length()/2)==line.charAt((line.length()/2)-1))
				System.out.println("Do-it");
			else
				System.out.println("Do-it-Not");
		}
	}

}
