

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;
import static java.lang.Integer.*;


public class Uva10013 {

	static byte[] bytesitos = new byte[1000001];
	public static void main(String[] args) throws Throwable {
		int[][] xxx = new int[10000000][2];
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String linea;(linea=in.readLine())!=null;) {
			int N = parseInt(linea);
			in.readLine();
			for (int casos = 0; casos < N; casos++) {
				int cant = parseInt(in.readLine());
				int pos = 1;
//				bytesitos = new byte[cant+1];
				for (int cantidades = (cant-1); cantidades >= 0; cantidades--) {
					StringTokenizer st = new StringTokenizer(in.readLine());
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					int tot = a + b;
					bytesitos[pos] = (byte) (tot%10);
					int cpyPos = pos;
					while( tot > 9 ){
//						System.out.println(cpyPos);
						tot = bytesitos[cpyPos-1]+1;
						bytesitos[cpyPos-1] = (byte) ( tot%10 );
						cpyPos = cpyPos-1;
					}
					pos++;
				}
//				System.out.println(Arrays.toString(bytesitos));
				boolean cerosIzq = true;
				for (int i = 0; i < cant+1; i++) {
					if( cerosIzq ) cerosIzq = bytesitos[i]==0;
					if( !cerosIzq ) 
						sb.append(bytesitos[i]);
					if(cerosIzq && cant == i)
						sb.append(bytesitos[i]);
				}
				sb.append("\n");
				if(casos<N-1){
					sb.append("\n");
					in.readLine();
				}
				Arrays.fill(bytesitos, (byte) 0);
			}
			
			break;
//			String res = sb.substring(0, sb.length()-2);
		}
		System.out.print(new String(sb));
	}
}
