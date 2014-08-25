import java.io.*;
public class Uva1124 {
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		for(String line; (line = in.readLine())!=null;){
			sb.append( line ).append( "\n" );
		}
		System.out.print(new String(sb));
	}
}
