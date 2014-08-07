import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class boxes {


	static double epsilon = 1e-4;
	
	static double busquedaBinaria(int[] a , double lI, double lS, double totalCajas){
		double  lM=-1.;
		
		double log = Math.log(lS)/epsilon;
		
		Arrays.sort(a);
		TreeSet<Double> s = new TreeSet<Double>();
		
//		for(double j=0;j<log;++j){
	
		while(Math.abs(lI-lS) > epsilon && lI<lS){
			lM= (lI+lS)/2.;
			
			double cajas = 0;
			boolean encontre = s.contains(lM);//&&false;
			
			for(int i=a.length-1;i>=0&&!encontre;--i){
//				System.out.println("i: " + a[i]  + " . " +Math.ceil(((double)(double)a[i]/(double)lM)));
				cajas+=Math.ceil((a[i]/lM));
				if(cajas>totalCajas)
					encontre=true;
			}
			
			if(!s.contains(lM))
				s.add(lM);
//			System.out.println("lI " + lI + " lS " + lS +" cajas "  + cajas   + " lM " + lM);
			if( totalCajas >= cajas )
				lS = lM;
			else if(lI < lM+1)
				lI = lM;
			
		}
		System.out.println("fin " + lI +" -- " + lS + " lm " + lM);
		return lI;
	}
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(String ln;(ln = in.readLine())!=null;){
			StringTokenizer st = new StringTokenizer(ln);
			int C = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
			if(C==-1 && B == -1)break;
			int[]d = new int[C];
			int max = Integer.MIN_VALUE;
			for(int i=0;i<C;++i)
				max = Math.max(max, (d[i]=Integer.parseInt(in.readLine())));
			Arrays.sort(d);
			System.out.println((int)(busquedaBinaria(d, 0, max, B)+1));
			in.readLine();
		}
	}

}
