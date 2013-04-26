

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=689
 * @veredict Accepted 
 * @problemId 748
 * @problemName  Exponentiation
 * @judge http://uva.onlinejudge.org/
 * @category ac
 * @level medium
 * @date 27/03/2011
 **/ 

public class Uva748 {

	public static void main(String[] args) throws Throwable {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		while((linea=bf.readLine())!=null){
			String decimal = linea.split(" +")[0];
			String numero = linea.split(" +")[1];
			String b = decimal.split("\\.")[1];
			int a = (int) (Double.parseDouble(decimal)*Math.pow(10, b.length()));
			int n = Integer.parseInt(numero);
			String respuesta = BigInteger.valueOf(a).pow(n).toString();
			int aCorrer = n * b.length();
			while( respuesta.length() < aCorrer )
				respuesta="0"+respuesta;
			respuesta = respuesta.substring(0, (respuesta.length()-aCorrer))+"."+respuesta.substring((respuesta.length()-aCorrer));
			int c=0;
			while(respuesta.charAt(respuesta.length()-c-1)=='0')
				c++;
			respuesta = respuesta.substring(0,(respuesta.length()-c));
			System.out.println(respuesta);
		}
	}

}
