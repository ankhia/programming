import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Uva10131 {

	static HashMap<String, Integer> h;
	static int[][] el;
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		el = new int[2][];
		h = new HashMap<String, Integer>();
		int i = 0;
		for (String line ; (line = in.readLine())!=null; i++ ) {
			StringTokenizer st = new StringTokenizer(line);
			h.put(line, i);
		}
		el = new int[2][h.size()];
		int k = 0;
		for ( String s : h.keySet()) {
			StringTokenizer st = new StringTokenizer(s);
			el[0][k] = Integer.parseInt(st.nextToken());
			el[1][k] = Integer.parseInt(st.nextToken());
			k++;
		}
		
		for (int j = 0; j < el.length; j++) {
			System.out.println(Arrays.toString(el[j]));
		}
	}

}
