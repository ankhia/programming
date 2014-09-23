import java.util.*;
import java.io.*;
import static java.lang.Integer.*;

public class Uva7554873279 {
	static TreeMap<Character, Integer> charToNumber;
	static TreeMap<String, Integer> numbers;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		init();
		int casos = parseInt(in.readLine().trim());
		in.readLine();
		for(int caso = 0; caso < casos ; caso++){
			numbers = new TreeMap<String, Integer>();
			int cantNumbers = parseInt(in.readLine().trim());
			for (int i = 0; i < cantNumbers; i++) {
				String number = cleanNumber(in.readLine( ).trim());
				if( numbers.containsKey(number) )
					numbers.put(number, numbers.get(number)+1);
				else
					numbers.put(number, 1);
			}
			
			int cant = 0;
			for (String string : numbers.keySet()) {
				if( numbers.get(string) > 1 ){
					cant++;
					String imp = string.substring(0, 3).concat("-").concat(string.substring(3, string.length()));
					sb.append(imp).append(" ").append(numbers.get(string)).append("\n");
				}
			}
			if( cant == 0 ) sb.append("No duplicates.\n");
			
			if( caso < casos-1 ){
				sb.append("\n");
				in.readLine( );
			}
		}
		System.out.print(new String(sb));
	}

	static void init( ){
		charToNumber = new TreeMap<Character, Integer>();
		charToNumber.put('A', 2);
		charToNumber.put('B', 2);
		charToNumber.put('C', 2);
		charToNumber.put('D', 3);
		charToNumber.put('E', 3);
		charToNumber.put('F', 3);
		charToNumber.put('G', 4);
		charToNumber.put('H', 4);
		charToNumber.put('I', 4);
		charToNumber.put('J', 5);
		charToNumber.put('K', 5);
		charToNumber.put('L', 5);
		charToNumber.put('M', 6);
		charToNumber.put('N', 6);
		charToNumber.put('O', 6);
		charToNumber.put('P', 7);
		charToNumber.put('S', 7);
		charToNumber.put('R', 7);
		charToNumber.put('T', 8);
		charToNumber.put('U', 8);
		charToNumber.put('V', 8);
		charToNumber.put('W', 9);
		charToNumber.put('X', 9);
		charToNumber.put('Y', 9);
	}

	static String cleanNumber( String number ){
		StringBuilder sb = new StringBuilder( );
		for (int i = 0; i < number.length(); i++) {
			char actual = number.charAt(i);
			if( Character.isLetter(actual) )
				sb.append(charToNumber.get(actual));
			else if( actual != '-' )
				sb.append( actual );
		}
		return new String(sb);
	}
}
