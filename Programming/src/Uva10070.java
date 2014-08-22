import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Uva10070 {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		int i = 0;
		for (String line; (line=in.readLine())!=null;) {
			if(i>0) sb.append("\n");
			i++;
			BigInteger year = new BigInteger(line);
			boolean isSomething = false;
			if( isLeapYear(year) ){
				isSomething = true;
				sb.append("This is leap year.\n");
			}
			if( isHuluculuYear(year) ){
				isSomething = true;
				sb.append("This is huluculu festival year.\n");
			}
			if( isBulukuluYear(year) ){
				isSomething = true;
				sb.append("This is bulukulu festival year.\n");
			}
			if(!isSomething)sb.append("This is an ordinary year.\n");
		}
		System.out.print(new String(sb));
	}
	
	static boolean isLeapYear( BigInteger b ){
		BigInteger cuatro = BigInteger.valueOf(4);
		BigInteger cien = BigInteger.valueOf(100);
		BigInteger cuatrocien = BigInteger.valueOf(400);
		if( (b.mod(cuatro).equals(BigInteger.ZERO) && !b.mod(cien).equals(BigInteger.ZERO)) || b.mod(cuatrocien).equals(BigInteger.ZERO) )
			return true;
		return false;
	}

	static boolean isHuluculuYear( BigInteger b ){
		BigInteger quince = BigInteger.valueOf(15);
		if( b.mod(quince).equals(BigInteger.ZERO) )
			return true;
		return false;
	}
	
	static boolean isBulukuluYear( BigInteger b ){
		BigInteger quince = BigInteger.valueOf(55);
		if( b.mod(quince).equals(BigInteger.ZERO) && isLeapYear(b) )
			return true;
		return false;
	}
}
