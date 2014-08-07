import java.io.*;
import java.util.*;
import static java.lang.Math.*;
import static java.lang.Integer.*;
public class Uva119 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int a = 0;
		for(String ln;(ln = in.readLine())!=null;){
			if(a>0)sb.append("\n");
			int n = parseInt(ln);
			HashMap<String, int[]> sums = new HashMap<String, int[]>();
			String names[] = new String[n];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i=0;i<n;++i)
				sums.put(names[i]=st.nextToken(), new int[3]);
			for(int i=0;i<n;++i){
				st = new StringTokenizer(in.readLine());
				String name = st.nextToken();
				int costGit = parseInt(st.nextToken());
				int m = parseInt(st.nextToken());
				sums.get(name)[0]=-costGit;
				sums.get(name)[2]=m;
				for(int j=0;j<m;++j){
					String friend = st.nextToken();
					sums.get(friend)[1]+=ceil(costGit/m);
				}
			}
			
			for(int i=0;i<n;++i){
				int val = 0;
				if(sums.get(names[i])[2]>0){
					val = (sums.get(names[i])[0]*-1)-(((int) floor((sums.get(names[i])[0]*-1)/sums.get(names[i])[2]))*sums.get(names[i])[2]);
					sums.get(names[i])[0]=(int) (sums.get(names[i])[0]+sums.get(names[i])[1])+val;
				}else
				{
					sums.get(names[i])[0]=sums.get(names[i])[1];
				}
				sb.append(names[i]).append(" ").append(sums.get(names[i])[0]).append("\n");
			}
			a++;
		}
		System.out.print(new String(sb));
	}

}
