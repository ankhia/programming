import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva10141 {

	static String[] names;
	static int[] proposals;
	static double[] prices;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		int caso = 1;
		for(String line; (line = in.readLine())!=null; caso++){
			if(line.equals("0 0")) break;
			StringTokenizer st = new StringTokenizer(line);
			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken()); 
			for (int i = 0; i < n; i++) 
				in.readLine();
			names = new String[p];
			proposals = new int[p];
			prices = new double[p];
			for (int i = 0; i < p; i++) {
				names[i] = in.readLine();
				st = new StringTokenizer(in.readLine());
				prices[i] = Double.parseDouble(st.nextToken());
				proposals[i] = Integer.parseInt(st.nextToken());
				for (int j = 0; j < proposals[i]; j++) {
					in.readLine();
				}
			}
			
			int indexMajor = 0;
			double compliance = Double.MIN_VALUE;
			for (int i = 0; i < proposals.length; i++) {
				double calc = (double)((double)proposals[i]/(double)n);
				if( calc > compliance ){
					indexMajor = i;
					compliance = calc;
				}else if(calc == compliance){
					if( prices[i] < prices[indexMajor] ){
						indexMajor = i;
					}
				}
			}
			
			sb.append("RFP #"+caso+"\n").append(names[indexMajor]).append("\n").append("\n");
		}
		System.out.print(new String(sb.substring(0, sb.length()-1)));
	}
}
