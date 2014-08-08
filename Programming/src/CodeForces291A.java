import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class CodeForces291A {

	static HashMap<Integer, Integer> num;
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		num = new HashMap<Integer, Integer>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		boolean valid = true;
		int cont = 0;
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(a!=0){
				if( num.get(a)!=null){
					num.put(a, num.get(a)+1);
				}else{
					num.put(a, 1);
				}
				if( num.get(a) > 2 )
					valid = false;
			}
		}
		if( valid ){
			for (Integer key : num.keySet()) {
				if( num.get(key)==2)
					cont++;
			}
			System.out.println(cont);
		}else
			System.out.println("-1");

	}

}
