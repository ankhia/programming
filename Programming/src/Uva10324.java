

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva10324 {

	static long[] sumas;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		int casos = 1;
		for (String line; (line = in.readLine())!=null; casos++) {
			if(line.equals(""))break;
			sumas = new long[line.length()];
			sumas[0] = Long.parseLong(line.charAt(0)+"");
			for (int i = 1; i < line.length(); i++)
				sumas[i] = sumas[i-1] + Long.parseLong(line.charAt(i)+"");
			int q = Integer.parseInt(in.readLine());
			sb.append("Case "+casos+":\n");
			for (int j = 0; j < q; j++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int min = Math.min(a, b);
				int max = Math.max(a, b);
				if( (sumas[max]-sumas[min>0?min-1:min]) == (max - (min>0?min-1:min))  || (sumas[max]-sumas[min>0?min-1:min]) == 0 )
					sb.append("Yes\n");
				else sb.append("No\n");
			} 
		}
		System.out.print(new String(sb));
	}
}
