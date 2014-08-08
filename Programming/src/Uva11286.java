

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Uva11286 {

	static TreeMap<String, Integer> popularity;
	static int[][]pop;
	static String[] courses;
	
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line; (line = in.readLine())!= null; ) {
			int casos = Integer.parseInt(line);
			if(casos==0)break;
			courses = new String[casos];
			popularity = new TreeMap<String, Integer>();
			pop = new int[casos][5];
			int max=Integer.MIN_VALUE;

			for (int c = 0; c < casos; c++) {
				line = in.readLine().trim();
				StringTokenizer st = new StringTokenizer(line);
				for (int i = 0; i < pop[c].length; i++)
					pop[c][i]=Integer.parseInt(st.nextToken());	

				Arrays.sort(pop[c]);
				String key = Arrays.toString(pop[c]);
				if(popularity.get(key)==null)
					popularity.put(key, 1);
				else
					popularity.put(key, popularity.get(key)+1);
				int w = popularity.get(key);
				if( w > max ){
					max  = w;
				}
				courses[c] = Arrays.toString(pop[c]);
			}
			int cantEst=0;
			for (int c = 0; c < casos; c++) {
				if(popularity.get(courses[c])==max)
					cantEst++;
			}
			sb.append(cantEst+"\n");
		}
		System.out.print(new String(sb));
	}

}
