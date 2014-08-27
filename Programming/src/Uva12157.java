import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva12157 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		int casos = Integer.parseInt(in.readLine());
		for (int caso = 0; caso < casos; caso++) {
			sb.append("Case ").append(caso+1).append(": ");
			int totalMile = 0;
			int totalJuice = 0;
			int calls = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < calls; i++) {
				int call = Integer.parseInt(st.nextToken( ));
				totalMile  += ( Math.ceil( call / 30.  ) );
				if( call % 30 == 0 ) totalMile++;
				totalJuice += ( Math.ceil( call / 60.  ) );
				if( call % 60 == 0 ) totalJuice++;
			}
			totalMile*=10;
			totalJuice*=15;
			sb.append(  totalMile < totalJuice ? "Mile "+totalMile : totalMile == totalJuice ? "Mile Juice "+totalJuice : "Juice "+totalJuice  ).append("\n");
		}
		System.out.print(new String(sb));
	}

}
