import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CodeForces266A {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String line ; (line=in.readLine())!=null;){
			int n = Integer.parseInt(line);
			String colours = in.readLine();
			int remove = 0;
			boolean red = true;
			boolean green = true;
			boolean blue = true;
			while( red || green || blue ){
				if( colours.indexOf("RR") != -1 ){
					colours = colours.replaceFirst("RR", "R" );
					remove++;
				}else{
					red = false;
				}
				if( colours.indexOf("GG") != -1 ){
					colours = colours.replaceFirst("GG", "G" );
					remove++;
				}else{
					green  = false;
				}
				if( colours.indexOf("BB") != -1 ){
					colours = colours.replaceFirst("BB", "B" );
					remove++;
				}else{
					blue = false;
				}
			}
			System.out.println(remove);
		}
	}
}
