import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Uva10940 {

	static int v[] = new int[500001];
	static int p[] = new int[100000]; 
	static LinkedList<Integer> a ;
	public static void main(String[] args) throws Throwable{
		for (int i = 0; i < p.length; i++) {
			p[i] = (int) Math.pow(2, i);
		}
		v[1]=1;v[2]=2;
		int c = 1;
		for (int i = 3; i < v.length; ) {
			int par = 2;
			for (int j = 0; j < p[c] && i < v.length; j++) {
				v[i]=par;
				par += 2;
				i++;
			}
			c++;
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line ; (line = in.readLine() )!=null; ) {
			int n = Integer.parseInt(line);
			if(n==0)break;
			sb.append(v[n]+"\n");
		}
		System.out.print(new String(sb));
	}
}
