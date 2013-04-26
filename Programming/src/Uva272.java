
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=208
 * @veredict Accepted 
 * @problemId 272
 * @problemName  TEX Quotes
 * @judge http://uva.onlinejudge.org/
 * @category AC
 * @level easy
 * @date 12/11/2011
 **/ 

public class Uva272 {

	public static void main(String ... args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		boolean inicial = true;
		while((linea=bf.readLine())!=null){
			for(int i=0; i< linea.length();++i){
				if((linea.charAt(i)+"").equals("\""))
				{
					if(inicial){
						linea = linea.substring(0, i) + "``" + linea.substring(i+1);
						inicial=false;
					}else{
						linea = linea.substring(0, i) + "''" + linea.substring(i+1);
						inicial = true;
					}
				}
			}
			System.out.println(linea);
		}
	}
}
