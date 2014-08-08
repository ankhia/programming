import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
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
			LinkedList<Integer> sol = new LinkedList<Integer>();
			LinkedList<Integer> otro = new LinkedList<Integer>();
			for(int i=0;i<N;++i){
				sol.add(i+1);
				otro.add(i+1);
			}
			int j=0;
			while( sol.size()>X && j < deck.length){
				int con = 0;
				for(int i=0;i<sol.size();++i){
					con++;
					if(con==deck[j])
					{
						con=0;
						sol.remove(i);
						i--;
					}
					if(sol.size()==X)break;
				}
//				System.out.println("carta "+ deck[j]+" "+ sol);
				j++;
			}
			if(sol.size()!=X)
				sol=otro;
			int flag = 0;
			for (int i = 0; i < sol.size(); i++) {
				if(flag > 0 ) sb.append(" ");
					sb.append(sol.get(i));
					flag++;
			}
			sb.append("\n").append("\n");
		}
		System.out.print(new String(sb.substring(0,sb.length()-1)));
	}
}