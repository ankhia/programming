import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Uva10127 {

	public static void main(String[] args) throws Throwable {
		Scanner in = new Scanner( new InputStreamReader( System.in ));
		StringBuilder sb = new StringBuilder( );
		while( in.hasNext() ){
			int n = in.nextInt( );
			sb.append(getDigits( n )+"\n");
		}
		System.out.print(new String(sb));
	}
	private static int getDigits(int n) {
		int actual = 1;
		int digitos = 1;
		while (actual % n != 0 ) {
			actual = ( (actual * 10) +1 ) % n;
			digitos++;
		}
		return digitos;
	}


}
