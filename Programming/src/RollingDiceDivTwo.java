

import java.util.Arrays;

public class RollingDiceDivTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new RollingDiceDivTwo();
		System.out.println(RollingDiceDivTwo.minimumFaces(new String[]{"137", "364", "115", "724"}));

	}
	
	static  int minimumFaces(String[] rolls){
		
		int vec[] = new int[rolls[0].length()];
		Arrays.fill(vec, 0);
		
		int[][] aux = new int[rolls.length][rolls[0].length()];
		for (int i = 0; i < rolls.length; i++) {
			for (int j = 0; j < rolls[0].length(); j++) {
				aux[i][j] = Integer.parseInt(rolls[i].charAt(j)+"");
			}
			Arrays.sort(aux[i]);
		}
				
		for (int i = 0; i < rolls.length; i++) {
			for (int j = 0; j < rolls[0].length(); j++) {
				if( aux[i][j] > vec[j] )
					vec[j] = aux[i][j];
				else
					vec[j] = aux[i-1][j];
			}
		}
		int suma = 0;
		for (int i = 0; i < vec.length; i++) {
			System.out.println(vec[i]);
			suma+=vec[i];
		}
		return suma;
	}

}
