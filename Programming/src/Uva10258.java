import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Uva10258 {
	
	static TreeMap<Integer, int[]> score;
	static TreeMap<Integer, int[]> penales;
	static TreeMap<Integer, boolean[]> solved;
	static StringBuilder sb = new StringBuilder(  );
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder( );
		int N = Integer.parseInt(in.readLine());
		in.readLine();
		for (int i = 0; i < N; i++) {
			score = new TreeMap<Integer,int[]>();
			solved = new TreeMap<Integer, boolean[]>();
			penales = new TreeMap<Integer, int[]>();
			for (String line; (line = in.readLine())!=null && line.length()>0;) {
				StringTokenizer st = new StringTokenizer(line);
				int team = Integer.parseInt(st.nextToken())-1;
				int penalPosition = Integer.parseInt(st.nextToken())-1;
				int valuePosition = Integer.parseInt(st.nextToken());
				char judge = st.nextToken().trim().charAt(0);
//				if( judge ==  'C' || judge == 'I' ){
					int[] penalties;
					boolean[] solve;
					int[] cantPenales;
					if( !score.containsKey(team) ){
						penalties = new int[10];
						solve = new boolean[9];
						cantPenales = new int[9];
					}
					else{
						penalties = score.get(team);
						solve = solved.get(team);
						cantPenales = penales.get(team);
					}
					if( judge == 'I' && !solve[penalPosition]){
						cantPenales[penalPosition] += 1;
					}else if( judge== 'C' && !solve[penalPosition] ){
						penalties[penalPosition] += valuePosition; 
						penalties[penalties.length-1]+=valuePosition;
						solve[penalPosition]=true;
					}
					score.put(team, penalties);
					solved.put(team, solve);
					penales.put(team, cantPenales);
				}
//			}
			solve( );
			if( i < N-1 )
				sb.append("\n");
		}
		System.out.print(new String(sb));
	}
	
	
	private static void solve() {
		int[][] res = new int[score.size()][2];
		int j = 0;
		for (Integer team : solved.keySet() ) {
			boolean[] problems = solved.get(team);
			int cant = 0;
			for (int i = 0; i < problems.length; i++) {
				if(problems[i]) {
					score.get(team)[score.get(team).length-1]+= penales.get(team)[i]*20;
					cant++;
				}
			}
			res[j][0] = team;
			res[j][1] = cant;
			j++;
		}
		
		Arrays.sort(res, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if( o1[1]>o2[1] || o1[1]<o2[1]) 
					return -(o1[1]-o2[1]);
				else {
					int penalty1 = score.get(o1[0])[score.get(o1[0]).length-1];
					int penalty2 = score.get(o2[0])[score.get(o2[0]).length-1];
					if( penalty1 == penalty2 )
						return (o1[0]-o2[0]);
					else
						return (penalty1-penalty2);
				}
			}
		});
		for (int i = 0; i < res.length; i++) 
			sb.append( (res[i][0]+1)+" "+res[i][1]+" "+score.get(res[i][0])[score.get(res[i][0]).length-1]  ).append("\n");
	}

}
