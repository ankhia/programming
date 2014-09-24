import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Uva120 {

	static int s[];
	static ArrayList<Integer> flips;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line; (line=in.readLine())!=null;) {
			StringTokenizer st = new StringTokenizer( line );
			s = new int[st.countTokens()];
			for (int i = 0; i < s.length; i++){ 
				if(i>0) sb.append(" ");
				s[i] = Integer.parseInt(st.nextToken());
				sb.append(s[i]);
			}
			solve();	
			sb.append("\n");
			for (int i = 0; i < flips.size(); i++) {
				if(i>0) sb.append(" ");
				sb.append(flips.get(i));
			}
			if( flips.size() > 0)
				sb.append(" ");
			sb.append("0").append("\n");
		}
		System.out.print(new String(sb));
	}
	
	static boolean termino(  ){
		int[] cpy = s.clone( );
		Arrays.sort(cpy);
		for (int i = 0; i < cpy.length; i++) {
			if( cpy[i]!=s[i])
				return false;
		}
		return true;
	}
	
	static void solve( ){
		flips= new ArrayList<Integer>();
		int idOrd = s.length;
		while( !termino( ) ){
			int max = Integer.MIN_VALUE;
			int flip = -1;
			for (int i = 0; i < idOrd; i++) {
//				System.out.println(s[i]>max);
				if(s[i]>max){
					max = s[i];
					flip = i;
				}
			}
//			System.out.println("--->"+flip +" "+max);
			if( flip != 0 ){
				flips.add(s.length-flip);
				flipflip(flip);
			}
//			System.out.println(Arrays.toString(s));
			if(!termino( )){
				flips.add(s.length-(idOrd-1));
				flipflip(idOrd-1);
			}
			idOrd--;
//			System.out.println(Arrays.toString(s));
		}
	}
	
	static void flipflip( int i ){
		int cpy[] = s.clone();
		for (int j = i+1; j < s.length; j++) 
			cpy[j]=s[j];
		for (int j = 0, k = i; k >= 0; k--, j++) 
			cpy[j]=s[k];
		s = cpy;
	}
}
