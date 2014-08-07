import java.io.*;
import java.util.*;

public class Acm5735 {

	static int[] numeros ;
	static int[] pos;
	static int[] min ;
	static int[] max;
	public static void main(String[] args) throws Throwable {
		Scanner in = new Scanner(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int c = 1;
		pos = new int[1000001];
		while( true ){
			if( n== 0 && a == 0 && b == 0)break;
			sb.append("Case "+c+"\n");
			numeros = new int[n];
			min = new int[a];
			max = new int[b];
			for (int i = 0; i < n; i++) {
				numeros[i]=in.nextInt();
				pos[numeros[i]]=i;
			}
			int[] cpy = numeros.clone( );
			Arrays.sort(cpy);
			for (int i = 0; i < a; i++) {
				min[i] = pos[cpy[i]];
			}
			for (int i = cpy.length-b , j = 0; i < cpy.length; i++, j++) {
				max[j]=pos[cpy[i]];
			}
			
			Arrays.sort(min);
			Arrays.sort(max);
			
			for (int i = 0; i < min.length; i++) {
				sb.append(min[i]+1);
				if(i<min.length-1)
					sb.append(" ");
			}
			sb.append("\n");
			for (int i = max.length-1; i>=0; i--) {
				sb.append(max[i]+1);
				if(i > 0)
					sb.append(" ");
			}
			sb.append("\n");
			n = in.nextInt();
			a = in.nextInt();
			b = in.nextInt();
			c++;
		}
		System.out.print( new String( sb ) );
	}
}