import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class unicycles {

	static int m ;
	static int n ;
	static int[] lines;
	static ArrayList<Integer> a ;
	static int[] mem;

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line; (line = in.readLine())!=null; ) {
			StringTokenizer st = new StringTokenizer(line);
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			lines = new int[n];
			mem = new int[1<<n];
			for (int i = 0; i < n; i++) {
				lines[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(lines);
			a = subconjuntos();
			sb.append(f((1<<n)-1)+"\n");
		}
		System.out.print(new String(sb));
	}

	static int f(int s) {
		if(mem[s]!=0) return mem[s];
		else if(s==0) return 0;
		else {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < a.size(); i++) {
				if( ( s&a.get(i) )!= 0 ) {
					int nuevo = s^a.get(i); 
					int sol = f( nuevo&s )+1;
					min = Math.min(sol,min);
				}
			}
			return mem[s]=min;
		}
	}

	static ArrayList<Integer> subconjuntos(  ){
		ArrayList<Integer> M = new ArrayList<Integer>();
		for(int i = 1; i < (1<<n); ++i) {
			ArrayList<Integer> elSubc = new ArrayList<Integer>(); 
			for(int j = 0; j < n; ++j) {
				if((i&(1<<j)) != 0) 
					elSubc.add(j);
			}
			int d = -1;
			boolean sirve = true;
			for (int j = 1; j < elSubc.size() && sirve; j++) {
				if(d == -1){
					d = lines[elSubc.get(j)] - lines[elSubc.get(j-1)];
				}else{
					if(lines[elSubc.get(j)] - lines[elSubc.get(j-1) ] != d )
						sirve = false;
				}
			}
			if(d!=-1) 
				if( lines[elSubc.get(0)]-d >= 0 ||  lines[elSubc.get(elSubc.size()-1)]+d < m ) sirve = false;
			if(sirve) M.add(i);
		}
		return M;
	}
}
