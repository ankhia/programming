

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Uva10739 {

	static String pal;
	static int[][]mem;
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(in.readLine());
		for (int i = 0; i < casos; i++) {
			pal = in.readLine();
			mem = new int[pal.length()][pal.length()];
			for (int j = 0; j < pal.length(); j++) {
				Arrays.fill(mem[j],Integer.MAX_VALUE);
			}
			System.out.println("Case "+(i+1)+": "+f(0,pal.length()-1));
			
//			for (int j = 0; j < mem.length; j++) {
//				System.out.println(Arrays.toString(mem[j]));
//			}
		}

	}

	static int f(int i, int j){
		if(mem[i][j]!=Integer.MAX_VALUE)
			return mem[i][j];
		if(i>=j)
			return mem[i][j]=0;
		if(pal.charAt(i)==pal.charAt(j))
			return mem[i][j]=f(i+1,j-1);
		else
			return mem[i][j]=Math.min(f(i+1,j-1)+1, (Math.min(f(i, j-1)+1, f(i+1,j)+1)));
	}
	
//	static int f(int i, int j){
//		if(i>=j)
//			return 0;
//		if(pal.charAt(i)==pal.charAt(j))
//			return f(i+1,j-1);
//		else
//			return Math.min(f(i+1,j-1)+1, (Math.min(f(i, j-1)+1, f(i+1,j)+1)));
//	}

}
