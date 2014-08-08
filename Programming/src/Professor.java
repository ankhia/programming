

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Professor {

	static LinkedList<Integer> lista;
	static double q0;
	static double q1;
	static double q2;
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String linea; !(linea=in.readLine()).equals("0 0 0");) {
			lista = new LinkedList<Integer>();
			StringTokenizer st = new StringTokenizer(linea);
			long alfa = Long.parseLong(st.nextToken());
			long beta = Long.parseLong(st.nextToken());
			long n = Long.parseLong(st.nextToken());
			
			q0=alfa;q1=beta;q2=(1+q1)/q0;
			lista.add((int)q0);lista.add((int)q1);lista.add((int)q2);
			while( Math.round(q1)!=alfa && Math.round(q2)!=beta ){
				q0=q1;q1=q2;q2=(1+q1)/q0;
				lista.add((int)q2);
			}
			System.out.println(lista.get(((int)(n%lista.size()))));
		}
	}
}
