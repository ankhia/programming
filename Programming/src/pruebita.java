
public class pruebita {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void test( String sunrise, String sunset, String ini, String end ){
		String[]sr = sunrise.split(":");
		int horasr = Integer.parseInt(sr[0]);
		int minsr = Integer.parseInt(sr[1]);
		String[]ss = sunset.split(":");
		int horass = Integer.parseInt(ss[1]);
		int minss = Integer.parseInt(ss[1]);
		String[]in = ini.split(":");
		String[] en = end.split(":");
		int horaini = Integer.parseInt(in[0]);
		int minini = Integer.parseInt(in[1]);
		int horafin = Integer.parseInt(en[0]);
		int minfin = Integer.parseInt(en[1]);
		if( horaini > Integer.parseInt(sr[0]) || ( horaini == horasr && minini >= minss ) ){
			
		}
	}
	
}
