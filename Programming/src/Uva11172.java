
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2113
 * @veredict Accepted 
 * @problemId 11172
 * @problemName Relational Operators
 * @judge http://uva.onlinejudge.org/
 * @category AdHoc
 * @level easy
 * @date 21/12/2011
 **/

public class Uva11172 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(in.readLine());
		while(casos-->0){
			StringTokenizer st = new StringTokenizer(in.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			if(a>b)
				System.out.println(">");
			else if(b>a)
				System.out.println("<");
			else
				System.out.println("=");
		}
	}
}
