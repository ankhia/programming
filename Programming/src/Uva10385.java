import java.io.*;
import java.util.*;

public class Uva10385 {
	
	static int n;
	static double t,k,r;
	static double [][] vecPart = null;
	static double rF, kF;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		while(line != null){
			t = Integer.parseInt(line);
			n = Integer.parseInt(reader.readLine());
			r = 0;
			k = t;
			vecPart = new double [n][2];
			for(int i = 0; i < n; i++){
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
				vecPart[i][0] = Double.parseDouble(tokenizer.nextToken());
				vecPart[i][1] = Double.parseDouble(tokenizer.nextToken());
			}
			solucion();
			line = reader.readLine();
			if(line!=null&&line.trim().equals("")){
				line = reader.readLine();
			}
		}

	}
	
	static void solucion(){
		StringBuilder builder = new StringBuilder();
		while(k - r >= 1e-4){
			double izq = r +(k-r)/3;
			double der = r +2*(k-r)/3;
			double mejorTiempoIzq = tiempoMejor(izq);
			double mejorTiempoDer = tiempoMejor(der);
			double miTiempIzq = (izq / vecPart[n-1][0]) + ( (t - izq) / vecPart[n-1][1]);
			double miTiempDer = (der / vecPart[n-1][0]) + ( (t - der) / vecPart[n-1][1]);
			double timeIzq = mejorTiempoIzq - miTiempIzq;
			double timeDer = mejorTiempoDer - miTiempDer;
			if(timeIzq < timeDer){
				r = izq ;
			}else if(  timeIzq > timeDer ){
				k = der;
			}else{
				r = izq;
				k = der;
			}
		}
			double mejorTiempo = tiempoMejor(r);
			double miTiemp = (r / vecPart[n-1][0]) + ( (t - r) / vecPart[n-1][1]);
			
			String num = String.format(Locale.US, "%.2f", r);
			String num2 = String.format(Locale.US, "%.2f", (t-r));
			String time = String.format(Locale.US, "%.0f", ((mejorTiempo-miTiemp)*3600));
			if( ((mejorTiempo-miTiemp)*3600) >=0)
				builder.append("The cheater can win by "+time+" seconds with r = "+num+"km and k = "+num2+"km.\n");
			else
				builder.append("The cheater cannot win.\n");
		System.out.print(builder);
	}
	
	static Double tiempoMejor(double r){
		Double mejorTime = Double.MAX_VALUE;
		for(int i = 0; i < n-1; i++){
			double tiempoTot = (r / vecPart[i][0]) + ( (t-r) / vecPart[i][1]);
			if(tiempoTot < mejorTime)
				mejorTime = tiempoTot;
		}
		return mejorTime;
	}

}
