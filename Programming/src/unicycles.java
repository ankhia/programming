import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class unicycles {

	static int[] lines;
	static int m ;
//	static int 
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String line ; (line = in.readLine())!=null;) {
			StringTokenizer st = new StringTokenizer(line);
			m = Integer.parseInt(st.nextToken()); //length of road
			int n = Integer.parseInt(st.nextToken()); //lines
			lines = new int[n];
			for (int j = 0; j < n; j++) {
				int i = Integer.parseInt(st.nextToken());
				lines[j] = i;
			}
			
			
		}
	}
	
//	public static int g( int S, int d ){
//		for (int i = 0; i < d; i++) {
//			if( existe( i ) ){
//				boolean posible = true;
//				boolean haySinUtilizar = false;
//				for ( int j = 0; j < m ; j+=d ){
//					if( !existe(j) ){
//						posible = false;
//					}else{
//						haySinUtilizar |= esta(S, j); 
//					}
//				}
//				if(posible && haySinUtilizar ) return i;
//			}
//			
//		}
//	}
//	
//	
//	public static f( int S, int d ){
//		
//		
//	}
//	
//	public static boolean existe( int i ){
//		for (int j = 0; j < lines.length; j++) {
//			if( lines[j] == i ){
//				return true;
//			}
//		}
//		return false;
//	}
	
	public static boolean esta(int S, int bit ){
		return (S&=1<<bit)==0?true:false;
	}

}
