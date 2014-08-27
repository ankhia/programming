import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva12503 {
	static int[] instructions;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		int cases = Integer.parseInt(in.readLine( ));
		for (int caso = 0; caso < cases; caso++) {
			int cant = Integer.parseInt(in.readLine());
			instructions = new int[ cant ];
			int pos = 0;
			for (int ins = 0; ins < cant; ins++) {
				String line = in.readLine().trim();
				if( line.equals("LEFT") ){
					instructions[ins] = -1;
					pos+=instructions[ins];
				}else if( line.equals("RIGHT")){
					instructions[ins] = 1;
					pos+=instructions[ins];
				}else{
					StringTokenizer st = new StringTokenizer(line);
					st.nextToken();st.nextToken();
					int index = Integer.parseInt(st.nextToken());
					instructions[ins] = instructions[index-1];
					pos+=instructions[index-1];
				}
			}
			sb.append(pos).append("\n");
		}
		System.out.print(new String(sb));
	}
}
