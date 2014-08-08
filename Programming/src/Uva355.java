

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=291
 * @veredict Accepted 
 * @problemId 355
 * @problemName The Bases Are Loaded
 * @judge http://uva.onlinejudge.org/
 * @category Math Ac
 * @level easy
 * @date 10/12/2012
 **/ 

public class Uva355 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for ( String linea; (linea=in.readLine())!=null;) {
			StringTokenizer st = new StringTokenizer(linea);
			int base = Integer.parseInt(st.nextToken());
			int baseTo = Integer.parseInt(st.nextToken());
			String number = st.nextToken();
			
			if(legal(number,base)){
				try{
					BigInteger nNumber = new BigInteger(number, base);
					String res = nNumber.toString(baseTo);
					sb.append(number+" base "+base+" = "+res.toUpperCase()+" base "+baseTo+"\n" );
				}catch(Exception e){
					sb.append(number+" is an illegal base "+base+" number\n");
				}
				
			}else{
				sb.append(number+" is an illegal base "+base+" number\n");
			}
		}
		System.out.print(new String(sb));
	}

	private static boolean legal(String number, int base) {
		for (int i = 0; i < number.length(); i++) {
			if(base <=10 && (!Character.isDigit(number.charAt(i)) || Integer.parseInt(number.charAt(i)+"")>base ))
				return false;
			else if(Character.isLetter(number.charAt(i)) && (number.charAt(i)-'A')+10 > base )
				return false;
		}
		return true;
	}
}
