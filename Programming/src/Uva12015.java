/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=562
 * @veredict Accepted 
 * @problemId 12015
 * @problemName Google is Feeling Lucky
 * @judge http://uva.onlinejudge.org/
 * @category adhoc
 * @level easy
 * @date 08/08/2014
 **/ 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Uva12015 {
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append("Case #"+(i+1)+":").append("\n");
			String[] web = new String[10];
			int[][] orden = new int[10][2];
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < 10; j++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				web[j] = st.nextToken();
				orden[j][0] = j;
				orden[j][1] = Integer.parseInt(st.nextToken());
				max = Math.max(max, orden[j][1]);
			}
			
			Arrays.sort(orden, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1]-o2[1];
				}
			});
			
			for (int j = 0; j < orden.length; j++) {
				if(orden[j][1]==max)
					sb.append(web[orden[j][0]]).append("\n");
			}
		}
		System.out.print(new String(sb));
	}
}
