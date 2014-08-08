

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=3976
 * @veredict Accepted 
 * @problemId 12531
 * @problemName Hours and Minutes
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level easy
 * @date 11/12/2012
 **/
public class Uva12531 {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String line; (line=in.readLine())!=null; ) {
			int grade = Integer.parseInt(line);
			if(grade%6==0)
				System.out.println("Y");
			else
				System.out.println("N");
		}
	}
}
