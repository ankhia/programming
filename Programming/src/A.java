import java.io.BufferedReader;
import java.io.InputStreamReader;


public class A {

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		int n = Integer.parseInt(in.readLine());
		char datos[] = in.readLine( ).toCharArray();
		int cant = 0;
		for (int i = 0; i < datos.length; i+=(n)) {
			if( (i-1)>=0 && (i-2)>=0 && (i-3)>=0){
				if( datos[i-1] == datos[i-2] && datos[i-2]==datos[i-3]){
					cant++;
				}
			}
		}
		sb.append(cant+"\n");
		System.out.print(new String(sb));
	}


}
