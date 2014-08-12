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


public class Uva661 {
	static int[] aparatos;
	static boolean []operaciones;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int caso = 1;
		for(String line; (line = in.readLine())!=null;){
			StringTokenizer st = new StringTokenizer(line.trim());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int cap = Integer.parseInt(st.nextToken());
			if( n ==0 && m == 0 && cap == 0 ) break;
			sb.append("Sequence "+(caso++)+"\n");
			aparatos=new int[n];
			operaciones=new boolean[n];
			for (int i = 0; i < n; i++) 
				aparatos[i] = Integer.parseInt(in.readLine().trim());
			boolean blow = false;
			int tmp = cap;
			int max = 0;
			for(int i = 0 ; i < m ; i++){
				int ind = Integer.parseInt(in.readLine().trim())-1;
				if( operaciones[ind])
					tmp += aparatos[ind];
				else {
					if( tmp - aparatos[ind] < 0 )
						blow = true;
					else{
						tmp -= aparatos[ind];
						max = Math.max(max, cap-tmp);
					}
				}
				operaciones[ind]=!operaciones[ind];
			}
			if(blow) sb.append("Fuse was blown.\n\n");
			else sb.append("Fuse was not blown.\nMaximal power consumption was "+max+" amperes.\n\n");
		}
		System.out.print(new String(sb));
	}
}
