import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Uva12250 {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int i = 1;
		for (String line; (line = in.readLine())!=null && !line.equals("#"); i++) {
			System.out.print("Case "+i+": ");
			if(line.equals("HELLO"))
				System.out.println( "ENGLISH");
			else if(line.equals("HOLA"))
				System.out.println( "SPANISH");
			else if(line.equals("HALLO"))
				System.out.println( "GERMAN");
			else if(line.equals("BONJOUR"))
				System.out.println( "FRENCH");
			else if(line.equals("CIAO"))
				System.out.println( "ITALIAN");
			else if( line.equals("ZDRAVSTVUJTE"))
				System.out.println( "RUSSIAN");
			else 
				System.out.println("UNKNOWN");
		}
	}

}
