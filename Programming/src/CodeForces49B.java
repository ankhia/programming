

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://www.codeforces.com/problemset/problem/49/B
 * @veredict Accepted
 * @problemId 49B
 * @problemName  Sum
 * @judge http://uva.onlinejudge.org/
 * @category AdHoc - Math
 * @level easy
 * @date 03/08/2012
 **/
public class CodeForces49B {

	public static void main(String[] args) throws Throwable
	{
		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
		StringBuilder sb = new StringBuilder( );
		for ( String line; ( line =  in.readLine( ) )!=null; ) {
			StringTokenizer st = new StringTokenizer(line);
			String s1 = st.nextToken( );
			String s2 = st.nextToken( );
			int large = Integer.MIN_VALUE;
			for(int i=0; i<=1000; i++){
				int c1=-1;int c2=-1;
				try {c1 = Integer.parseInt(s1,i);} catch (Exception e) {}
				try {c2 = Integer.parseInt(s2,i);} catch (Exception e) {}
				if(c1!=-1 && c2 != -1) {
					String sum = fromDecimal2((c1+c2), i);
					if(sum.length()>large)
						large = sum.length();
				}
			}
			sb.append(large+"\n");		
		}
		System.out.print(new String(sb));
	}

	public static String fromDecimal2(int n, int b)
	{
		String chars="0123456789ABCDEFGHIJ";
		String result="";

		while(n>0)
		{
			result=chars.charAt(n%b) + result;
			n/=b;
		}

		return result;
	}
}
