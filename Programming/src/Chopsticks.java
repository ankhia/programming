

import java.util.Arrays;

public class Chopsticks {

	public static void main(String[] args) {
		System.out.println(new Chopsticks().getmax(new int[]{1,1,1,1,1}));
	}
	
	public static int getmax(int[] length){
		Arrays.sort(length);
		int cantidad = 0;
		for (int i = 1; i < length.length; i+=2) {
			if( length[i] == length[i-1] )
				cantidad++;
			else
				i--;
		}
		return cantidad;
	}
	

}
