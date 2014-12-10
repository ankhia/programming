import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Uva402 {

	static int N;
	static int X;
	static int s;
	static int[] deck;
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int caso = 1;
		for(String line; (line = in.readLine())!=null; caso++){
			StringTokenizer st = new StringTokenizer(line);
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			sb.append("Selection #").append(caso).append("\n");
			deck = new int[20];
			for (int i = 0; i < 20; i++) 
				deck[i]=Integer.parseInt(st.nextToken());

			List<Integer> people = new ArrayList<Integer>();
			for (int i = 1; i <= N; i++) {
				people.add( i );
			}
			int indexDeck = 0;
			while( people.size() > X && indexDeck < deck.length ){
				System.out.println(people.size() + " " + deck[indexDeck]);
				for (int i = 0, j = 0; i < people.size() &&  people.size() > X; j++) {
					i+=deck[indexDeck];
					if( i-j < people.size() )
						people.remove(i-j);
					System.out.println(people + " ");
				}
				indexDeck++;
			}

		}
		System.out.print(new String(sb.substring(0,sb.length()-1)));
	}
}