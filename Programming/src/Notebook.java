import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;


public class Notebook {

	static class Escaner{
		BufferedReader in;
		StringTokenizer st;
		Escaner(){
			in = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}
		int nextInt() throws Throwable{
			if(st.hasMoreTokens())return Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine().trim());
			return nextInt();
		}
	}

	
	public static void main(String[] args) throws Throwable{
		Escaner in = new Escaner();
		StringBuilder sb = new StringBuilder( );
		int n = in.nextInt();
		while(n!=0){
			double pt[][] = new double[n][2];
			for (int i = 0; i < n; i++) {
				pt[i][0] = in.nextInt();
				pt[i][1] = in.nextInt();
			}
			double closest =0;// closestPair(pt); 
			sb.append(closest>=10000?"INFINITY":String.format(Locale.US, "%.4f", closest)).append("\n");
			n = in.nextInt();
		}
		System.out.print(new String(sb));
	}
/*
	static Comparator<double[]> c=new Comparator<double[]>() { 
		public int compare(double[] p, double[] q) 
		{return Math.abs(p[0]-q[0])>=9.9e-12?(p[0]<q[0]?-1:1):(p[1]!=q[1]?(p[1]<q[1]?-1:1):0);} 
	}; 
	static int f(int n) {return n>=0?n:-n-1;} 
	static double closestPair(double[][] pt) { 
		Arrays.sort(pt,c); int k=pt.length-1,z[]=new int[k+1]; 
		for (int i=k; i>=0; i--) z[i]=i==k||Math.abs(pt[i][0]-pt[i+1][0])>=9.9e-12?i:z[i+1]; 
		for (int i=0; i<k; i++) if (c.compare(pt[i],pt[i+1])==0) return 0; 
		return Math.sqrt(closestPair(pt,0,k,z)); 
	} 
	static double closestPair(double[][] pt, int lI, int lS, int[] z) { 
		if (lI>=lS) return Double.POSITIVE_INFINITY; 
		int lM=(lI+lS)/2; double inf=Double.NEGATIVE_INFINITY,x=pt[lM][0]; 
		double r=Math.min(closestPair(pt,lI,lM,z),closestPair(pt,lM+1,lS,z)),d=Math.sqrt(r); 
		for (int i=f(Arrays.binarySearch(pt,lI,lM+1,new double[]{x-d+1e-11,inf},c)); i<=lM; i++) 
			for (int j1=lM+1,j2,j; j1<=lS&&pt[j1][0]<pt[i][0]+d; j1=j2+1) { 
				j=f(Arrays.binarySearch(pt,j1,(j2=z[j1])+1,new double[]{pt[j1][0],pt[i][1]},c)); 
				for (int k=0; k<2; k++) if (j1<=j-k&&j-k<=j2) r=Math.min(r,ds(pt[i],pt[j-k])); 
			} 
		return r; 
	}
	static double ds(double[] a, double[] b) {return (b[0]-a[0])*(b[0]-a[0])+(b[1]-a[1])*(b[1]-a[1]);}
	*/
}
