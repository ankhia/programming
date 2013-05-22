import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Uva785 {

	static ArrayList<char[]> array;
	static char[][] m ;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		array = new ArrayList<char[]>();
		for (String line;(line = in.readLine())!=null; ) {
			if(line.contains("_") ) {
				m = new char[array.size()][];
				for (int i = 0; i < array.size(); i++) 
					m[i] = array.get(i);
				
				for (int i = 0; i < m.length; i++) {
					for (int j = 0; j < m[i].length; j++) {
						System.out.print(m[i][j]);
					}
					System.out.println();
				}
				
				array = new ArrayList<char[]>();
			}else{
				array.add(line.toCharArray());
			}
		}
	}
}
