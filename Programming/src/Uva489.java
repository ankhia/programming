

import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Uva489 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line; (line=in.readLine())!=null; ) {
			int round = Integer.parseInt(line);
			if(round<0)break;

			String sol = in.readLine();
			String guess = in.readLine();
			Set<Character> a = new HashSet<Character>();
			for (int i = 0; i < sol.length(); i++) {
				a.add(sol.charAt(i));
			}
			//Character[] charcosito = a.toArray(new Character[0]);
			int hang_state = 0;
			int lose = 0;
			for (int i = 0; i < guess.length() && !a.isEmpty() && lose!=7; i++) 
				if(a.contains(guess.charAt(i)))
					a.remove(guess.charAt(i));
				else lose++;
			
			if( lose < 7 && a.size()==0)
				hang_state = 2;
			else if (lose<7)
				hang_state = 0;
			else 
				hang_state = 1;
			
			sb.append("Round "+round+"\n");
			if( hang_state == 0 )
				sb.append("You chickened out.\n");
			else if(hang_state == 1)
				sb.append("You lose.\n");
			else
				sb.append("You win.\n");
		}
		System.out.print(new String(sb));
	}
}
