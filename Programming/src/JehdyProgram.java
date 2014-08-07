import java.io.BufferedReader;


public class JehdyProgram {

	public static void main(String[] args) {
		for(int i = 0 ; i < 100 ; i++)
			System.out.print(besitos(i) +" ");
	}
	
	//fibonacci
	public static int besitos( int n ){
		if( n == 0 || n == 1 ) return n;
		else return besitos( n-1 )+besitos( n-2 );
	}
}
