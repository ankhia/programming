

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/external/116/11678.html
 * @veredict Accepted 
 * @problemId 11678
 * @problemName  Exchanging Cards
 * @judge http://uva.onlinejudge.org/
 * @category Ad Hoc
 * @level easy
 * @date 26/04/2012
 **/ 

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;

public class Uva11678 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (StringTokenizer st; (st = new StringTokenizer(in.readLine()))!=null;) {
			int a = parseInt(st.nextToken());
			int b = parseInt(st.nextToken());
			if( a==0 && b ==0 ) break;
			
			Set<Integer> ali = new TreeSet<Integer>();
			Set<Integer> bau = new TreeSet<Integer>();
			
			
			st = new StringTokenizer(in.readLine());
			while( st.hasMoreTokens() )
				ali.add(parseInt(st.nextToken()));
			st = new StringTokenizer(in.readLine());
			while( st.hasMoreTokens() )
				bau.add(parseInt(st.nextToken()));
			int contA = 0; 
			
			for (Integer i : ali ) {
				boolean encontre = bau.contains(i);
				if(!encontre)
					contA++;
			}
				
			int contB = 0; 
			for (Integer i : bau ) {
				boolean encontre = ali.contains(i);
				if(!encontre)
					contB++;
			}
			sb.append(Math.min(contA, contB)+"\n");
		}
		System.out.print(new String(sb));
	}

}
