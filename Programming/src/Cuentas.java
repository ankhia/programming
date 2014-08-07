import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Cuentas {

	static String[] nombre  = { "Rotativo",
								"Gasolina", 
								"Parqueadero", 	
								"Servidor",	
								"Claro Celular", 	
								"Soat" ,	
								"Cuota",	
								"Tarjeta Credito",
								"DirecTV Oficina"};
	static int[] todo 		= { 180000,120000,120000,12500,107000,86426,456000,154000,8500 };
	
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < todo.length; i++) {
			sum+=todo[i];
		}
		int a = 880000;
		int b = 1050000;
		int x = (a-b+sum)/2;
		System.out.println("quincena 1: " + x);
		System.out.println("quincena 2: " + (sum-x));
		System.out.println("libre x quin: " + ((a+b)-sum)/2);
	}
}
