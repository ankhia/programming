import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class trading {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line; (line = in.readLine())!=null; ) {
			if(line.equals("*"))break;
			char[] txt=line.toCharArray();
			int q = Integer.parseInt(in.readLine());
			for (int cq = 0; cq < q; cq++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int i1 = Integer.parseInt(st.nextToken());
				int j1 = Integer.parseInt(st.nextToken());
				int c = 0;
				boolean paila = false;
				for (int i = i1,j=j1; i < line.length() && j< txt.length &&!paila; i++,j++) {
						if(txt[i]==txt[j])
							c++;
						else
							paila=true;
				}
				sb.append(c+"\n");
			}
		}
		System.out.print(new String(sb));
	}
}
