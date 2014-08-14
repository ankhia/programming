import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Uva10815 {

	static TreeSet<String> words ;
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		words = new TreeSet<String>();
		StringBuilder sb = new StringBuilder();
		for (String line; (line = in.readLine())!=null; ) {
			line = clean(line.trim().toLowerCase( ));
			StringTokenizer st = new StringTokenizer(line, "&");
			while(st.hasMoreTokens() ){
				String word = st.nextToken( );
				if( word != "&"){
					words.add(word);
				}
			}
		}
		for (String string : words)
			sb.append(string).append("\n");
		System.out.print(new String(sb));
	}
	
	private static String clean( String line ){
		for (int i = 0; i < line.length(); i++) {
			if( !Character.isLetter(line.charAt(i)))
				line = line.replace(line.charAt(i), '\0');
		}
		line = line.replaceAll(" ", "&");
		line = line.replace("\0", "&");
		String temp = line;
		for (int i = 0; i < temp.length(); i++) {
			char caracter = temp.charAt(i);
			if( !Character.isLetter(caracter) && caracter!='&'){
				line = line.replace(caracter+"", "");
			}
		}
		return line.trim();
	}
}

