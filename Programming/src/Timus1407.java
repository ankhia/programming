

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * @author Angie Milena Vega Leon
 * @veredict -- 
 * @problemId 1407
 * @linkDeArchivo http://acm.timus.ru/problem.aspx?space=1&num=1407
 * @problemName  One-two, One-two
 * @judge Timus
 * @category 
 * @level --
 * @date 22/07/2012
 **/
public class Timus1407 {

	static int N ;
	static BigInteger[] mem;

	public static void main(String[] args) throws Throwable {
		
		mem = new BigInteger[101];
		llenarMem();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		
		for (String linea; (linea = in.readLine()) != null ; ) {
			N = Integer.parseInt(linea);
			if(mem[N]!=null)
				sb.append(mem[N]);
			else
				sb.append("No solution");
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
	
	static void llenarMem( ){
		
		mem[0] = BigInteger.valueOf(2);
		for (int i = 1; i < 101; i++) {
			BigInteger potencia = BigInteger.valueOf(2);
			potencia = potencia.pow(i);
			String numero = mem[i-1].toString();
			Queue<String> cola = new LinkedList<String>();
			cola.add(numero);
			boolean encontre = false;
			while(!cola.isEmpty() && !encontre){
				String a = cola.poll();
//				System.out.println(a +"         " + potencia + "              i: " +i);
				if(a.length()<101){
					BigInteger b = new BigInteger(a);
					if( b.mod(potencia).compareTo(BigInteger.ZERO) == 0){
						mem[i] = b;
						encontre = true;
					}else{
						cola.add("1"+a);
						cola.add("2"+a);
					}
				}else break;
			}
			if(!encontre)
				mem[i] = null;
		}
	}
}
