

import java.io.*;
import java.util.*;

public class Uva484 {

	static HashMap<Integer, Integer> h ;
	static ArrayList<Integer> s;
	public static void main(String[] args) throws Throwable
	{
		h = new HashMap<Integer, Integer>();
		s = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		Scanner in = new Scanner(new InputStreamReader(System.in));
		while( in.hasNext() ){
			int a = in.nextInt();
			if(h.get(a)==null){
				s.add(a);
				h.put(a, 1);
			}
			else
				h.put(a, h.get(a)+1);
		}
		for (Integer a : s) {
			sb.append(a+" "+h.get(a)+"\n");
		}
		System.out.print(new String(sb));
	}
}
