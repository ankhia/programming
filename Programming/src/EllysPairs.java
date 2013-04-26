

import java.util.Arrays;

public class EllysPairs {

	public static void main(String[] args) {
		System.out.println(new EllysPairs().getDifference(new int[]{5, 1, 8, 8, 13, 7, 6, 2, 1, 9, 5, 11, 3, 4}));
	}
	
	public static int getDifference(int[] knowledge){
		Arrays.sort(knowledge);
		System.out.println(Arrays.toString(knowledge));
		
		int sumBest = knowledge[knowledge.length-1] + knowledge[0];
		int sumWorst = knowledge[knowledge.length/2] + knowledge[(knowledge.length/2) -1];
		return Math.abs(sumBest-sumWorst);
	}
}
