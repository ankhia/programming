import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Uva12403 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		int sum = 0;
		for (int i = 0; i < tc; i++) {
			String line[] = in.readLine().split(" ");
			if(  line[0].equals("donate") )
				sum += Integer.parseInt(line[1]);
			else
				System.out.println(sum);
		}
	}

}
