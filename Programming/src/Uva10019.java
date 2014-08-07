import java.io.*;
import java.util.*;

public class Uva10019 {


	static HashMap<Character, String> hex2bina;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in) );
		StringBuilder sb = new StringBuilder( );
		hex2bina = new HashMap<Character, String>();
		hex2bina.put('0', "0000");
		hex2bina.put('1', "0001");
		hex2bina.put('2', "0010");
		hex2bina.put('3', "0011");
		hex2bina.put('4', "0100");
		hex2bina.put('5', "0101");
		hex2bina.put('6', "0110");
		hex2bina.put('7', "0111");
		hex2bina.put('8', "1000");
		hex2bina.put('9', "1001");
		hex2bina.put('A', "1010");
		hex2bina.put('B', "1011");
		hex2bina.put('C', "1100");
		hex2bina.put('D', "1101");
		hex2bina.put('E', "1110");
		hex2bina.put('F', "1111");
		int tc = Integer.parseInt( in.readLine() );
		for (int i = 0; i < tc; i++) {
			int n = Integer.parseInt(in.readLine());
			sb.append(Integer.bitCount(n)+" ");
			String bina = hex2bin(n+"");
			int cant = 0;
			for (int j = 0; j < bina.length(); j++) {
				if( bina.charAt(j) == '1') cant++;
			}
			sb.append(cant+"\n");
		}
		System.out.print(new String(sb	));
	}
	static String hex2bin( String hexa ){
		String binary = "";
		for (int i = 0; i < hexa.length() ; i++) {
			binary += hex2bina.get(hexa.charAt(i));
		}
		return binary;
	}

}
