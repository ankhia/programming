

import java.io.*;
import java.util.*;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&category=24&problem=1048&mosmsg=Submission+received+with+ID+10455700
 * @veredict Accepted 
 * @problemId 10107
 * @problemName  What is the Median?
 * @judge http://uva.onlinejudge.org/
 * @category Math - AdHoc easy
 * @level easy
 * @date 09/08/2012
 **/ 

public class Uva10107 {

	static ArrayList<Integer> n = new ArrayList<Integer>();
	public static void main(String[] args) throws Throwable {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		while(sc.hasNext()){
			n.add(sc.nextInt());
			Collections.sort(n);
			int median = -1;
			if(n.size() == 1)
				sb.append(n.get(0)+"\n");
			else{
				if(n.size()%2==0){
					int a = (n.size()/2);
					median = (n.get(a)+n.get(a-1))/2;
				}else{
					int a = (n.size()/2);
					median = n.get(a);
				}
				sb.append(median+"\n");
			}
		}
		System.out.print(new String(sb));
	}
}
