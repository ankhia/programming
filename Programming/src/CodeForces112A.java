import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CodeForces112A {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String line ; (line = in.readLine())!=null ; ){
			String ln2 = in.readLine();
			String a = line.toLowerCase();
			String b = ln2.toLowerCase();
			if( a.compareTo(b)<0)
				System.out.println("-1");
			else if(a.compareTo(b)>0 )
				System.out.println("1");
			else
				System.out.println("0");
		}
	}
}
