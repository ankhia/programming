import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Uva12289 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ));
		int tc = Integer.parseInt(in.readLine());
		for (int i = 0; i < tc; i++) {
			String line = in.readLine();
			if(line.length()>3)
				System.out.println("3");
			else{
				int o = 0;
				int t = 0;
				String one = "one";
				String two = "two";
				for (int j = 0; j < line.length(); j++) {
					if( line.charAt(j) != one.charAt(j) ) o++;
					if( line.charAt(j) != two.charAt(j) ) t++;
				}
				System.out.println(o<t?"1":"2");
			}
		}
	}

}
