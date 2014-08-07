import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ACM6162 {

	static int MIN_NOC = 10*60;
	static int MIN_TOT = 50*60;
	public static void main(String[] args) throws  Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String line ; (line=in.readLine())!=null;) {
			int cantL = Integer.parseInt(line);
			if(cantL == 0 )break;
			boolean pass = true;
			int nocturnas=0;
			int total=0;
			for (int i = 0; i < cantL; i++) {
				line = in.readLine();
				String[] horas = line.split(" ");
				String[] n = horas[0].split(":");
				int hs = Integer.parseInt(n[0]);
				int ms = Integer.parseInt(n[1]);
				n = horas[1].split(":");
				int hss = Integer.parseInt(n[0]);
				int mss = Integer.parseInt(n[1]);
				n = horas[2].split(":");
				int hi = Integer.parseInt(n[0]);
				int mi = Integer.parseInt(n[1]);
				n = horas[3].split(":");
				int he = Integer.parseInt(n[0]);
				int me = Integer.parseInt(n[1]);

				double parcial = clockToMinutes(hi, mi, he, me);
				if(parcial > 120) pass = false;
				else if( beforeSunrise(clockToMinutes(hi, mi), clockToMinutes(hs, ms), parcial)){
					total+=parcial;
					nocturnas+=parcial;
				}else if( afterSunset(clockToMinutes(he, me), clockToMinutes(hss, mss), parcial)){
					total+=parcial;
					nocturnas+=parcial;
				}else{
					total+=parcial;
				}
			}
			if(nocturnas<MIN_NOC || total<MIN_TOT)
				pass = false;
			System.out.println(pass?"PASS":"NON");
		}
	}


	public static double clockToMinutes( int hi , int mi , int he, int me ) {
		int miniToHours = 60-mi;
		hi++;
		if( he < hi ) {
			miniToHours -= (60-me);
		}else if(he == hi){
			miniToHours += me;
		}else{
			miniToHours+=(he-hi)*60;
			miniToHours+=me;
		}
		return miniToHours;
	}

	public static double clockToMinutes(int h , int m ){
		return (h*60)+m;
	}

	static boolean beforeSunrise( double i , double s, double total ){
		double antes = total/2;
		if( s - i >= antes ) return true;
		return false;
	}

	static boolean afterSunset( double f , double ss, double total ){
		double antes = total/2;
		if( f - ss >= antes ) return true;
		return false;
	}

}