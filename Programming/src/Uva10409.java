import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Uva10409 {

	static int n;
	static int w;
	static int s;
	static int e;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String ln ; (ln = in.readLine())!=null;) {
			int casos = Integer.parseInt(ln);
			if(casos==0) break;
			int top = 1;
			n = 2;
			s = 5;
			w = 3;
			e = 4;
			for (int i = 0; i < casos; i++) {
				String instr = in.readLine();
				if( instr.equals("north")){
					n = top;
					top = s;
					s = Math.abs(7 - n);
				}else if( instr.equals("south")){
					s = top;
					top = n;
					n = Math.abs(7 - s);
				}else if( instr.equals("west")){
					w = top;
					top = e;
					e = Math.abs(7-w); 
				}else{
					e = top;
					top = w;
					w = Math.abs(7-e);
				}
			}
			System.out.println(top);
		}
	}
}
