import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Code333A {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		double a = Double.parseDouble(in.readLine());
		if(a%3==0|| a==1){
			System.out.println(1);
		}else{
			double x = a/3.;
			System.out.println(x);
			System.out.printf("asdasda  %.0f", x);
			System.out.println((long)Math.ceil(x));
		}
			
		
	}

}
