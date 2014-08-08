import java.io.*;
import java.text.NumberFormat;
import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Math.*;
public class Uva145 {

	static double[][] prices = new double[][]{{0.10,0.06,0.02},
		{0.25,0.15,0.05},
		{0.53,0.33,0.13},
		{0.87,0.47,0.17},
		{1.44,0.80,0.30}};
	static int[][] horarios=new int[][]{{8,18},{18,22},{22,8}};

	public static void main(String[] args) throws Exception {
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		int[] minutes = new int[1441];
		for(int i=0;i<horarios.length;++i){
			for(int j=horarios[i][0];j!= horarios[i][1];j=(j+1)%24){
				for(int p=0;p<60;++p)
					minutes[(j*60)+p]=i;
			}
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(String ln;(ln = in.readLine())!=null;){
			if(ln.equals("#"))break;
			StringTokenizer st = new StringTokenizer(ln);
			char[] sol = new char[39];
			Arrays.fill(sol, ' ');
			char range = st.nextToken().charAt(0);
			int posRange = range-'A';
			String tel = st.nextToken();
			for(int i=9, j=tel.length()-1;j>=0&&i>=0;j--,--i)
				sol[i]=tel.charAt(j);
			sol[30]=range;

			int minA = (parseInt(st.nextToken())*60) +parseInt(st.nextToken());
			int minB = (parseInt(st.nextToken())*60) +parseInt(st.nextToken());
			int[] time = new int[3];
			if(minA!=minB){
				for(int i= minA;i!=minB;i=(i+1)%(24*60))
					time[minutes[i]]++;
			}else{
				int i= minA+1;
				for(;i!=minB;i=(i+1)%(24*60))
					time[minutes[i]]++;
				time[minutes[minA]]++;
			}
			double cost  = (time[0]*prices[posRange][0]) +(time[1]*prices[posRange][1]) +(time[2]*prices[posRange][2]) ;
			String a = time[0]+"";
			for(int i=15, j=a.length()-1;i>=0&&j>=0;j--,i--)
				sol[i]=a.charAt(j);
			a = time[1]+"";
			for(int i=21, j=a.length()-1;i>=0&&j>=0;j--,i--)
				sol[i]=a.charAt(j);
			a = time[2]+"";
			for(int i=27, j=a.length()-1;i>=0&&j>=0;j--,i--)
				sol[i]=a.charAt(j);
			a = nf.format(cost).replaceAll(",", "");
			for(int i=38, j=a.length()-1;i>=0&&j>0;j--,i--)
				sol[i]=a.charAt(j);
			sb.append(new String(sol)).append("\n");
		}
		System.out.print(new String(sb));
	}

}
