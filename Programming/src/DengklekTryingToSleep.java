

import java.util.Arrays;

public class DengklekTryingToSleep {

	public static void main(String[] args) {
		System.out.println(new DengklekTryingToSleep().minDucks(new int[]{5,3,2}));
	}

	public static int minDucks(int[] ducks){
		Arrays.sort(ducks);
		int cont=0;
		if(ducks.length == 1)
			return 0;
		else{
			for(int i = 1; i<ducks.length;i++){
				cont += (ducks[i]-ducks[i-1])-1;
			}
		}
		return cont;
	}
}