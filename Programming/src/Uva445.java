

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Uva445 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line; (line = in.readLine()) != null ; ) {
			if(line.trim().isEmpty())
				sb.append("\n");
			else{

				int sum = 0;
				StringBuilder newAns = new StringBuilder();
				for (int i = 0; i < line.length(); i++) {
					char actual = line.charAt(i);
					if(Character.isDigit(actual)){
						sum+=Integer.parseInt(actual+"");
					}
					else if(actual == '!')
						newAns.append("\n");
					else {
						for (int j = 0; j < sum; j++) {
							if(actual == 'b')
								newAns.append(" ");

							else
								newAns.append(actual);
						}
						sum = 0;
					}
				}
				sb.append(newAns+"\n");
			}
		}
		System.out.print(new String(sb));
	}
}
