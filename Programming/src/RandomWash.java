import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class RandomWash {


	static String MSG_SALVADO = "PEGO EN EL PALO : ";
	static String MSG_LE_TOCO = " GOOOOLAZO DE ";
	static int rondas = 2;
	static int oport = 3;
	static ArrayList<String> od1enses;
	static boolean vo[];
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new FileReader("in.in"));

		od1enses = new ArrayList<String>();
		for (String line; (line=in.readLine())!=null;) {
			od1enses.add(line);
		}
		vo = new boolean[od1enses.size()];
		int min = 0, max = od1enses.size()-1;

		for (int i = 0; i < rondas; i++) {
			System.out.println("-------------------");
			System.out.println("      RONDA "+(i+1) );
//			Arrays.fill(vo, false);
			for (int j = 0; j < oport; j++) {
				int posOd1=min + (int)(Math.random() * ((max - min) + 1));
				if( !vo[posOd1] ){
					if( j<oport-1 ){
						System.out.print(MSG_SALVADO);
						suspensivos();
						System.out.println(od1enses.get(posOd1));
						
					}else{
						System.out.print(MSG_LE_TOCO);
						suspensivos();
						System.out.println(od1enses.get(posOd1));
//						vo[posOd1]=true;
					}
					vo[posOd1]=true;
				}else{
					j-=2;
				}
			}
		}
	}
	
	public static void suspensivos( ){
		try {
			for (int i = 0; i < 3; i++) {
				System.out.print(". ");
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
