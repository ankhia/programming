

import java.math.BigInteger;

public class BinaryPolynomialDivTwo {

	public static void main(String[] args) {
		System.out.println(new BinaryPolynomialDivTwo().countRoots(new int[]{1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0,
				 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1}));
	}

	public 	static int countRoots(int[] a){
		int P1 = 0;
		int P0 = 0;
		for (int i = 0; i < a.length; i++) {
			P1 += a[i] * 1;
			P0 += a[i] * ( (i==0)? 1: 0 );
		}
		if(P0 > 1) P0 %= 2;
		if(P1 > 1) P1 %=2;
		
		if(P1 == 0 && P0 == 0)
			return 2;
		else if( P1 == 0 || P0 == 0 )
			return 1;
		return 0;
	}
}
