

import java.io.*;
import java.util.Arrays;

import static java.lang.Integer.*;
/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1637
 * @veredict Accepted 
 * @problemId 10696
 * @problemName f91
 * @judge http://uva.onlinejudge.org/
 * @category Ac
 * @level easy
 * @date 10/12/2012
 **/ 

public class Uva10696 {

	static int[] mem ;
	public static void main(String[] args) throws Throwable {
		
		mem = new int[1000001];
		Arrays.fill(mem, -1);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int aCalcular = parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		while(aCalcular!=0){
			sb.append("f91("+aCalcular+") = "+f(aCalcular)+"\n");
			aCalcular = parseInt(in.readLine());
		}
		System.out.print(sb);
	}

	static int f(int n){
		if(mem[n]!=-1)
			return mem[n];
		if(n >= 101)
			return mem[n]=n-10;
		else
			return mem[n]=f(f(n+11));
	}
}
