import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Prueba {

	
	static int m[], N , K;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln;(ln = in.readLine())!=null;){
			StringTokenizer st = new StringTokenizer(ln);
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			m= new int[N+1];
			int suma= 0;
			for(int i=0;i<m.length;++i)suma+=(m[i]=Integer.parseInt(in.readLine()));
			int ini = 0;
			int fin = suma;
			int mid = (ini+fin)/2;
			while(ini<fin){
				
			}
			
		}
	}

}
