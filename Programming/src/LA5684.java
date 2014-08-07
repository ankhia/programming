import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class LA5684 {
	
	
	public static void main(String[] args) throws Throwable {
		System.out.println(System.currentTimeMillis());
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < n; tc++) {
			int nn = Integer.parseInt(in.readLine());
			int a = 0;
			int p = 0;
			int h = 0;
			int s = 0;
			for (int i = 0; i < nn; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				st.nextToken();
				
				if(!st.hasMoreTokens()){
					a++;
				}else{
					boolean y = false;
					int j = 0;
					while(st.hasMoreTokens()){
						String li = st.nextToken();
						if(li.contains("y") && j==0){
							p++;
							y=true;
						}
						else if(li.contains("y")){ 
							h++;
							y=true;
						}
						j++;
					}
					if(!y) s++;
				}
			}
			sb.append("Roll-call: "+(tc+1)+"\n");
			sb.append("Present: "+p+" out of "+nn+"\n");
			sb.append("Needs to study at home: "+h+" out of "+nn+"\n");
			sb.append("Needs remedial work after school: "+s+" out of "+nn+"\n");
			sb.append("Absent: "+a+" out of "+nn+"\n");
		}
		System.out.print(new String(sb));
	}
}
