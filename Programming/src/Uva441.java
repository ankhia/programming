

import java.math.BigInteger;
import java.util.Arrays;

public class Uva441 {
	//pascal (revisar Uva369)
	static BigInteger pascal[][];
	
    public static void main(String[] args){ 
    	trianguloPascal();
    	System.out.println(pascal[49][12]);
    }
    
    static void trianguloPascal( ){
    	pascal = new BigInteger[101][102];
		for (int i = 0; i < pascal.length; i++) 
			Arrays.fill(pascal[i], BigInteger.valueOf(-1));
		
		for (int i = 0; i < pascal.length; i++) {
			boolean termine = false;
			for (int j = 0; j < pascal[0].length && !termine; j++) {
				if(j==0) pascal[i][j]=BigInteger.ONE;
				else if( i-1 >= 0 && j-1 >= 0 ){
					if(pascal[i-1][j].compareTo(BigInteger.ZERO)==1)
						pascal[i][j] = pascal[i-1][j-1].add(pascal[i-1][j]);
					else {
						pascal[i][j] = BigInteger.ONE;
						termine = true;
					}
				}
			}
		}
    }
} 