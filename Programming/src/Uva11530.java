import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;


public class Uva11530 {

	static TreeMap<Character, Integer> values;
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		init();
		int n = Integer.parseInt(in.readLine().trim());
		StringBuilder sb = new StringBuilder( );
		for (int i = 0; i < n; i++) {
			sb.append("Case #"+(i+1)+": ");
			String line = in.readLine();
			int sum = 0;
			for (int j = 0; j < line.length(); j++) {
				char caracter = line.charAt(j);
				if( Character.isLetter(caracter))
					sum+=values.get(caracter);
				else if(Character.isWhitespace(caracter))
					sum+=1;
			}
			sb.append(sum+"\n");
		}
		System.out.print(new String(sb));
	}

	static void init( ){
		values = new TreeMap<Character, Integer>();
		values.put('a', 1 );
		values.put('b', 2 );
		values.put('c', 3 );
		values.put('d', 1 );
		values.put('e', 2 );
		values.put('f', 3 );
		values.put('g', 1 );
		values.put('h', 2 );
		values.put('i', 3 );
		values.put('j', 1 );
		values.put('k', 2 );
		values.put('l', 3 );
		values.put('m', 1 );
		values.put('n', 2 );
		values.put('o', 3 );
		values.put('p', 1 );
		values.put('q', 2 );
		values.put('r', 3 );
		values.put('s', 4 );
		values.put('t', 1 );
		values.put('u', 2 );
		values.put('v', 3 );
		values.put('w', 1 );
		values.put('x', 2 );
		values.put('y', 3 );
		values.put('z', 4 );
	}
}
