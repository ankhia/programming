import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;


public class Uva11650 {

	static TreeMap<String, String> tree;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		init( );
		int casos = Integer.parseInt(in.readLine());
		for (int i = 0; i < casos; i++) {
			System.out.println(tree.get(in.readLine().trim()));
		}
	}
	
	public static void init(){
		tree= new TreeMap<String, String>();
		for( int i = 11, j = 1; i >= 0 && j <= 12; i--,j++ ){
			tree.put( hora(i)+":00" , hora(j)+":00");
		}
		for (int i = 11, j = 0; i>=0 && j < 12; i--, j++) {
			for (int k = 1, l = 59; k < 60 && l >= 0 ; k++, l--) {
				tree.put( hora(i)+":"+minuto(l), hora(j)+":"+minuto(k));
			}
		}
	}
	
	public static String hora( int i ){
		return (i<10?(i==0?"12":("0"+i)):i+"");
	}
	
	public static String minuto( int i ){
		return (i<10?(i==0?"00":("0"+i)):i+"");
	}
}
