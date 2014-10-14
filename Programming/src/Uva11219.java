import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Uva11219 {

	static int yA ;
	static int mA ;
	static int dA ;
	static int yN ;
	static int mN ;
	static int dN ;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cases; i++) {
			in.readLine();
			sb.append("Case #").append(i+1).append(": ");
			String[] actualDate = in.readLine().split("/");
			String[] birthDate = in.readLine().split("/");
			dA = Integer.parseInt(actualDate[0]);
			mA = Integer.parseInt(actualDate[1]);
			yA = Integer.parseInt(actualDate[2]);
			
			dN = Integer.parseInt(birthDate[0]);
			mN = Integer.parseInt(birthDate[1]);
			yN = Integer.parseInt(birthDate[2]);
			
			int ano;
			if( yN > yA || ( yN==yA && mN > mA ) || ( yN == yA && mN == mA && dN > dA) )
				ano = -1;
			else{
				if( yN == yA ) ano = 0;
				else{
					if(mN < mA || ( mN == mA && dN <=dA ) ) 
						ano = yA - yN;
					else
						ano = (yA - yN)-1;
				}
			}
			
			if( ano > 130 ) sb.append("Check birth date\n");
			else if( ano != -1 ) sb.append(ano).append("\n");
			else sb.append("Invalid birth date").append("\n");
		}
		System.out.print(new String(sb));
	}
}
