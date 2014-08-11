import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2493
 * @veredict Accepted
 * @problemId 11498
 * @problemName  Division of Nlogonia
 * @judge http://uva.onlinejudge.org/
 * @category Implementation, Ad hoc
 * @level 2
 * @date 11/08/2014
 **/ 

public class Uva11498 {
	
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		for (String line ; (line = in.readLine())!=null; ) {
			int K = Integer.parseInt(line.trim());
			if(K==0)break;
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			for (int cases = 0; cases < K; cases++) {
				st = new StringTokenizer(in.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				
				if( i == N || j == M ) sb.append("divisa\n");
				//I 
				if( i > N && j > M ) sb.append("NE\n");
				//II
				if( i < N && j > M ) sb.append("NO\n");
				//III
				if( i < N && j < M ) sb.append("SO\n");
				//IV
				if( i > N && j < M ) sb.append("SE\n");
			}	
		}
		System.out.print(new String(sb));
	}
}
