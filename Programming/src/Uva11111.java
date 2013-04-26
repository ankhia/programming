
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2052
 * @veredict Wrong Answer
 * @problemId 11111
 * @problemName   Generalized Matrioshkas
 * @judge http://uva.onlinejudge.org/
 * @category DP
 * @level --
 * @date 11/12/2012
 **/

public class Uva11111 {

	static Stack<Integer> pila ; 
	static int []vec ;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		vec = new int[10000002];
		for (String linea; (linea = in.readLine())!=null; ) {
			StringTokenizer st = new StringTokenizer(linea);
			pila = new Stack<Integer>();
			int min = Integer.MAX_VALUE;
			while(st.hasMoreTokens()){
				int a = Integer.parseInt(st.nextToken());
				if(a<0){
					if( Math.abs(a) < Math.abs(min) ){

						if( !pila.isEmpty() ){
							int tope  =  pila.peek();
							if( vec[Math.abs(tope)]+Math.abs(a) < Math.abs(tope) ){
								vec[Math.abs(pila.peek())]+=Math.abs(a);
								pila.add(a);
							}else break;
							
						}else			
							pila.add(a);
						if(Math.abs(a)<Math.abs(min)) min = a;
					}else break;
				}else if(!pila.isEmpty()){
					int tope = pila.peek();
					if( Math.abs(tope)==Math.abs(a)){
						vec[Math.abs(tope)] = 0;
						pila.pop();
						if(pila.size()>0 && tope<0)
							min  = pila.peek();
					}else break;
				}
			}
			
			if(pila.size()>0)
				sb.append(":-( Try again.\n");
			else
				sb.append(":-) Matrioshka!\n");
			
			while(!pila.isEmpty())
				vec[Math.abs(pila.pop())] = 0;
//			for (int i = 0; i < 11; i++) {
//				System.out.println(i+" "+vec[i]);
//			}
//			Arrays.fill(vec, 0);
		}
		System.out.print(new String(sb));
	}

}
