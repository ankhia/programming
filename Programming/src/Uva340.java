import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Uva340 {

	static int clave[ ]; 
	static int hint[ ];
	static boolean usados[ ];
	static boolean isMatched[ ];
	static int strong;
	static int weak;
	
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		int game = 1;
		for (String ln; (ln=in.readLine())!=null; game++) {
			int n = Integer.parseInt(ln.trim());
			if(n==0)break;
			sb.append("Game "+game+":\n");
			clave = new int[n];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < n; i++)
				clave[i] = Integer.parseInt(st.nextToken());
			for ( ;; ) {
				usados = new boolean[n];
				isMatched = new boolean[n];
				hint = new int[n];
				strong = 0;
				weak = 0;
				st = new StringTokenizer(in.readLine().trim());
				int sum = 0;
				for (int i = 0; i < n; i++){
					hint[i]=Integer.parseInt(st.nextToken());
					sum+=hint[i];
				}
				if(sum==0)break;
				solve();
				sb.append("    ("+strong+","+weak+")\n");
			}
		}
		System.out.print(new String(sb));
	}
	
	static void print( ){
		System.out.println(Arrays.toString(clave));
		System.out.println(Arrays.toString(hint));
	}
	
	static void solve(  ){
//		print();
		for(int i = 0 ; i < clave.length; i++ ){
			if(clave[i]==hint[i]){
				strong++;
				usados[i]=true;
				isMatched[i]=true;
			}
		}

		for(int i = 0 ; i < clave.length; i++ ){
			boolean found = false;
			if( !isMatched[i] )
				for (int j = 0; j < hint.length && !found; j++) {
					if( clave[i]==hint[j] && !usados[j]){
						weak++;
						usados[j]=true;
						found=true;
					}
				}
		}
	}

}
