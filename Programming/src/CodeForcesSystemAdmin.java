import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CodeForcesSystemAdmin {

	
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int ax = 0;
		int ay = 0;
		int bx = 0;
		int by = 0;
		for (int tc = 0; tc < n; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int server = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if( server == 1 ){
				ax+=x;
				ay+=y;
			}else{
				bx+=x;
				by+=y;
			}
		}
		int ta = ax+ay;
		
		int mitad = (int) (ta/2.);
		if( ax >= mitad ) System.out.println("LIVE");
		else System.out.println("DEAD");
		ta = bx+by;
		mitad = (int) (ta/2.);
		if( bx >= mitad ) System.out.println("LIVE");
		else System.out.println("DEAD");
	}

}
