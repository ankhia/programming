

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;


/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=543
 * @veredict --  
 * @problemId 602
 * @problemName  What Day Is It?
 * @judge http://uva.onlinejudge.org/
 * @category --
 * @level --
 * @date 11/12/2012
 **/

public class Uva602 {

	public static final SimpleDateFormat fechaEntera = new SimpleDateFormat("MMMMM dd, yyyy 'is a' EEEEEEEEE",Locale.US);

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String linea; (linea=in.readLine())!=null ;) {
			StringTokenizer st = new StringTokenizer(linea);
			int mm = Integer.parseInt(st.nextToken());
			int dd = Integer.parseInt(st.nextToken());
			int yy = Integer.parseInt(st.nextToken());
			if(mm==0&&dd==0&&yy==0)break;
			try{
				System.out.println(yy);
				System.out.println(mm);
				System.out.println(dd);
				System.out.println(fechaEntera.format(new Date((yy-1900),(mm-1),dd)));
			}catch(Exception e){
				System.out.println(mm+"/"+dd+"/"+yy +" is an invalid date.");
			}
			
		}
		
		
	}

}
