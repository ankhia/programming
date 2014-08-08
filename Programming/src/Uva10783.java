

import java.io.BufferedReader;
import java.io.InputStreamReader;
//10783 - Odd Sum - 26-03-2012  - http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&category=24&problem=1724&mosmsg=Submission+received+with+ID+9912605
public class Uva10783 {

	public static void main(String[] args) throws Throwable {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(bf.readLine());
		for (int i = 0; i < casos; i++) {
			int a = Integer.parseInt(bf.readLine());
			int b = Integer.parseInt(bf.readLine());
			if(a%2==0) a++; if(b%2==0)b--;
			int suma = 0;
			for (int j = a; j <= b; j+=2) {
//				System.out.println("sumo"+j);
				suma+=j;
			}
			System.out.println("Case "+(i+1)+": "+suma);
		}
	}
}
