import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;


public class RandomSpots {

	static ArrayList<String> od1enses;
	static boolean vo[];
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new FileReader("in.in"));
		od1enses = new ArrayList<String>();
		for (String line; (line=in.readLine())!=null;) {
			od1enses.add(line);
		}
		vo = new boolean[od1enses.size()];
		int spot = 1;
		int min = 0;
		int max = od1enses.size()-1;
		int cont = od1enses.size();
		Random r = new Random();
		int posOd1=min + (int)(Math.random() * ((max - min) + 1)); 
	
		while(cont > 0){
			if( !vo[posOd1] ){
				Thread.sleep(1000);
				System.out.println( od1enses.get(posOd1) + "	" + spot);
				vo[posOd1] = true;
				cont--;
				spot++;
			}else{
				posOd1 = min + (int)(Math.random() * ((max - min) + 1)); 
			}
		}
		System.out.println();
		in = new BufferedReader(new FileReader("oficina.in"));
		for (String line; (line=in.readLine())!=null;) {
			System.out.println(line);
		}
	}
}
