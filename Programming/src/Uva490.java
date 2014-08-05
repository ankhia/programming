import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Uva490 {
	static ArrayList<String> lines ;
	public static void main(String[] args) throws Throwable {
		lines = new ArrayList<String>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int max = Integer.MIN_VALUE;
		for (String line; (line = in.readLine())!=null; ) {
			max = Math.max(max, line.length());
			lines.add(line);
		}
		
		StringBuilder sb = new StringBuilder( );
		for( int i=0; i < max ; i++){
			for (int j = lines.size()-1; j >= 0; j--) {
				sb.append( i < lines.get(j).length() ? lines.get(j).charAt(i):" " );
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));	
	}
}
