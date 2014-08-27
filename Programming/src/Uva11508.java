import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Uva11508 {

	static ArrayList<Integer> num;
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		for(String line ; (line=in.readLine())!= null ;){
			if( line.trim().equals("0") ) break;
			StringTokenizer st = new StringTokenizer(line.trim());
			num = new ArrayList<Integer>();
			int max = Integer.MIN_VALUE;
			while( st.hasMoreTokens() ){
				int n = Integer.parseInt(st.nextToken());
				num.add(n);
				max = Math.max(max, n);
			}
			if( max >= num.size() ) {
				sb.append("Message hacked by the Martians!!!").append("\n");
			}else {
				int sol[ ] = new int[num.size()];
				Arrays.fill(sol, -1);
				for (int i = 0; i < sol.length; i++) {
					if( num.indexOf(i)!=-1 ){
//						System.out.println(i +" " +num.get(num.indexOf(i)));
						sol[i] = i;
						num.remove(num.indexOf(i));
//						System.out.println(Arrays.toString(num.toArray()));
					}
				}
				for (int i = 0, j = 0; i < sol.length && num.size()>0; i++) {
					if(sol[i]==-1) {
						sol[i]=num.get(j);
						j++;
					}
				}
				for (int i = 0; i < sol.length; i++) {
					if(i > 0) sb.append(" ");
					sb.append(sol[i]);	
				}
				sb.append("\n");
			}
		}
		System.out.print(new String(sb));
	}
}
