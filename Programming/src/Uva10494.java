

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/external/104/10494.html
 * @veredict Accepted 
 * @problemId 10494
 * @problemName If We Were a Child Again
 * @judge http://uva.onlinejudge.org/
 * @category AdHoc
 * @level easy
 * @date 03/02/2013
 **/

public class Uva10494 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String linea; (linea=in.readLine())!=null;) {
			String[] prueba = linea.trim().split(" +");
			BigInteger numero1 = new BigInteger(prueba[0]);
			char operacion = prueba[1].charAt(0) ;
			int numero2 = Integer.parseInt(prueba[2]);
			BigInteger result;
			if(operacion=='/')
				result = numero1.divide(BigInteger.valueOf(numero2));
			else
				result = numero1.mod(BigInteger.valueOf(numero2));
			sb.append(result+"\n");
		}
		System.out.print(new String(sb));
	}
}
