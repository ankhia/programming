import java.io.*;
import java.util.*;
import static java.lang.Math.*;
import static java.lang.Integer.*;
public class Uva232 {
	public static void main(String[] args)throws Exception  {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int caso = 1;
		StringBuilder sb = new StringBuilder();
		for(String ln;(ln=in.readLine())!=null;){
			StringTokenizer st = new StringTokenizer(ln);
			int f = parseInt(st.nextToken()), c = parseInt(st.nextToken());
			char[][] m = new char[f][];
			for(int i=0;i<f;++i)
				m[i]=in.readLine().toCharArray();
			ArrayList<int[]> ver = new ArrayList<int[]>();
			ArrayList<int[]> hor = new ArrayList<int[]>();
			int cont = 1;
			for(int i=0;i<f;++i){
				for(int j=0;j<c;++j){
					if(m[i][j]!='*'){
						if(j==0)hor.add(new int[]{i,j,cont++});
						else if(j-1>=0 && m[i][j-1]=='*')hor.add(new int[]{i,j,cont++});
					}
					if(i==0)
						ver.add(new int[]{i,j,cont++});
					else if(i-1>=0 &&  m[i-1][j]=='*')
						ver.add(new int[]{i,j,cont++});
				}
			}
			
			System.out.println("ver");
			for(int[] x : ver){
				System.out.println(Arrays.toString(x));
			}
			System.out.println("hor");
			for(int[] x : hor){
				System.out.println(Arrays.toString(x));
			}			
			
			sb.append("puzzle #"+(cont++)+":\n");
			sb.append("Across\n");
			for(int i=0;i<hor.size();++i)
			{
				StringBuilder s = new StringBuilder();
				s.append(hor.get(i)[2]+".");
				for(int j=hor.get(i)[1];j<f;++j){
					if(m[hor.get(i)[0]][j]=='*')break;
					s.append(m[hor.get(i)[0]][j]);
				}
				s.append("\n");
				sb.append(s);
			}
		}
		System.out.print(new String(sb));
	}
}