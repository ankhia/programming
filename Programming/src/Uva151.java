import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Uva151 {

	static boolean []off;
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
		for (String line; (line = in.readLine()) != null; ) {
			int n = Integer.parseInt(line);
			if(n == 0)break;
			off=new boolean[n];
			int k = 5;
			int cpy = 5;
			off[0]=true;
			for (int i = 0; !go( ) ; i++ ) {
				if(i>=n)i=i%8;
				if((cpy == 0)|| i==0) {
					System.out.println(i+1);
					off[i]=true;
					cpy=k;
				}else if(!off[i]|| i==0){
					cpy--;
				}
			}
		}
	}
	
	public static boolean go( ){
		for (int i = 0; i < off.length; i++) {
			if( !off[i] )
				return false;
		}
		return true;
	}

}
