import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LA6164 {

	static String[][] m ;
	static int dot;
	static ArrayList<Integer> vAx;
	static ArrayList<Integer> vAy;
	static ArrayList<Integer> vAs;
	static ArrayList<Integer> vDx;
	static ArrayList<Integer> vDy;
	static ArrayList<Integer> vDs;
	static StringBuilder sb ; 
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String line = in.readLine();
		for ( ; line!=null; ) {
			int n = Integer.parseInt(line);
			if(n==0)break;
			vAx = new ArrayList<Integer>();
			vAy = new ArrayList<Integer>();
			vAs = new ArrayList<Integer>();
			vDx = new ArrayList<Integer>();
			vDy = new ArrayList<Integer>();
			vDs = new ArrayList<Integer>();
			m = new String[n][n];
			for (int i = 0; i < n; i++) {
				line = in.readLine();
				for (int j = 0; j < line.length(); j++) {
					m[i][j] = line.charAt(j)+"";
					if(m[i][j].equals(".")) dot++;
				}
			}
			in.readLine();
			for ( ;(line=in.readLine())!=null && !line.equals("Down"); ) {
				StringTokenizer st = new StringTokenizer(line);
				int y = (Integer.parseInt(st.nextToken()))-1;
				int x = (Integer.parseInt(st.nextToken()))-1;
				int sum = Integer.parseInt(st.nextToken());
				vAx.add(x);
				vAy.add(y);
				vAs.add(sum);
			}
			for ( ;(line=in.readLine())!=null && line.trim().contains(" "); ) {
				StringTokenizer st = new StringTokenizer(line);
				int y = Integer.parseInt(st.nextToken())-1;
				int x = Integer.parseInt(st.nextToken())-1;
				int sum = Integer.parseInt(st.nextToken());
				vDx.add(x);
				vDy.add(y);
				vDs.add(sum);
			}
			solve( );
			imprimir();
		}
		System.out.print(new String(sb));
	}

	static void solve( ){
		int n = m.length;
		while(dot>0){
			for (int k = 0; k < vAx.size( ); k++) {
				int cPA = 0;
				int sumA = 0;
				int posXA = -1;
				int posYA = -1;
				int i = vAx.get(k);
				boolean termine = false;
				for (int j = vAy.get(k); j < n && !termine; j++) {
					if( m[i][j].equals(".") ){ 
						cPA++;
						posXA = i;
						posYA = j;
					}else if(!m[i][j].equals("#")){
						sumA += Integer.parseInt(m[i][j]);
					}else if(m[i][j].equals("#")){
						termine = true;
					}
				}
				if(cPA == 1) {
					m[posXA][posYA] = Math.abs((sumA-vAs.get(k)))+"";
					dot--;
				}
			}	
			
			for (int k = 0; k < vDy.size( ); k++) {
				int cPD = 0;
				int posXD = -1;
				int posYD = -1;
				int sumD = 0;
				int j = vDy.get(k);
				boolean termine = false;
				for (int i = vDx.get(k); i < n&&!termine; i++) {
					if( m[i][j].equals(".") ){
						cPD++;
						posXD = i;
						posYD = j;
					}else if(!m[i][j].equals("#")){
						sumD += Integer.parseInt(m[i][j]);
					}else{
						termine = true;
					}
				}
				if(cPD == 1) {
					m[posXD][posYD] = Math.abs(sumD-vDs.get(k))+"";
					dot--;
				}
			}
		}
	}

	static void imprimir( ){
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				sb.append(m[i][j]);
			}
			sb.append("\n");
		}
		sb.append("\n");
	}
}

