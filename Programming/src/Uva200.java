import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;



public class Uva200 {

	static boolean[][] mAdy; 

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		mAdy=new boolean[30][30];
		String ant = null;
		TreeSet<Integer> letras = new TreeSet<Integer>();
		for (String line; (line = in.readLine())!=null; ) {
			if(line.charAt(0)=='#')break;
			if(ant == null){
				ant = line;
			}else{
				int min =Math.min(ant.length(), line.length());
				for(int i=0;i<min;++i){
					int f = (int)(ant.charAt(i)-'A');
					int c = (int)(line.charAt(i)-'A') ;
					letras.add(f);
					letras.add(c);
					if(f!=c){
						mAdy[f][c]=true;
						break;
					}
				}
				ant=line;
			}
		}
		int[][] lAdy = tolAdy(mAdy);
		int[] orden = topologicalSort(lAdy);
		for(int i=0;i<orden.length;++i){
			if(letras.contains(orden[i])){
				System.out.print((char)(orden[i]+'A'));
			}
		}
		System.out.println();
	}

	static int[][] tolAdy(boolean[][] mAdy){
		int[][] lAdy = new int[mAdy.length][];
		for(int i=0;i<mAdy.length;++i){
			ArrayList<Integer> t = new ArrayList<Integer>();
			for(int j=0;j<mAdy[i].length;++j){
				if(mAdy[i][j])
					t.add(j);
			}
			Integer[] m = t.toArray(new Integer[0]);
			int[] xx = new int[m.length];
			for(int j=0;j<xx.length;++j)xx[j]=m[j];
			lAdy[i]= xx;
		}
		
//		for(int i=0;i<lAdy.length;++i){
//			System.out.println("Desde " +  i +  " Cantidad hijos  " + lAdy[i].length);
//			for(int j=0;j<lAdy[i].length;++j){
//				System.out.print(lAdy[i][j]+" ");
//			}
//			System.out.println();
//		}
	
		return lAdy;
	}

	static int[] topologicalSort(int[][] lAdy) { // Retorna null si no recibe un DAG 
		int n=lAdy.length,state[]=new int[n]; List<Integer> r=new ArrayList<Integer>(); 
		for (int v=0; v<n; v++) if (state[v]==0&&!dfsTS(lAdy,v,state,r)) return null; 
		int t=r.size(),a[]=new int[t],i; for (i=0; i<t; i++) a[i]=r.get(t-1-i); return a; 
	} 
	static 	boolean dfsTS(int[][] lAdy, int v, int[] state, List<Integer> r) { 
		state[v]=1; 
		for (int w:lAdy[v]) if (state[w]==1||(state[w]==0&&!dfsTS(lAdy,w,state,r))) return false; 
		state[v]=2; r.add(v); return true; 
	} 
}
