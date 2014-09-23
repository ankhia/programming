import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Uva11650 {

	static TreeMap<String, String> tree;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		init( );
//		int casos = Integer.parseInt(in.readLine());
//		for (int i = 0; i < casos; i++) {
//			StringTokenizer st= new StringTokenizer( in.readLine( ) ,":");
//			int h = Integer.parseInt(st.nextToken());
//			int m = Integer.parseInt(st.nextToken());
			
//			double nH = Math.abs(((((h * 30) + m * 0.5) - 360 ) / 30));
//			System.out.println("-------->" + ((((h * 30) + m * 0.5) - 360 ) / 30));
//			int nM = Math.abs(((m * 6) - 360)/6);
//			if( nM == 60  ) nM = 0;
//			if( nH < 1 && nH > 0) nH=11;
//			System.out.println((nH<10?"0"+nH:nH)+":"+(nM<10?"0"+nM:nM));
//		}
	}
	
	public static void init(){
		tree= new TreeMap<String, String>();
		int h = 1;
		int m = 59;
		for (int i = 0; i < 12; i++) {
			for (int j = 0, k = 60; j < 60 && k >= 0 ; j++, k--) {
				System.out.println(i+":"+j + " = " + (i-1)+":"+k);
			}
		}
	}
	
}
