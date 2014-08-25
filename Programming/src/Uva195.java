/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&category=24&problem=131&mosmsg=Submission+received+with+ID+14023568
 * @veredict Accepted 
 * @problemId 195
 * @problemName  Anagram
 * @judge http://uva.onlinejudge.org/
 * @category arrays, sorting
 * @level 2
 * @date 11/08/2014
 **/ 


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;


public class Uva195 {

	static Comparator<Character> comparador = new Comparator<Character>() {
		@Override
		public int compare(Character o1, Character o2) {
			if( Character.compare(Character.toLowerCase(o1), Character.toLowerCase(o2)) == 0 )
				return (int)o1 - (int)o2;
			else 
				return Character.compare(Character.toLowerCase(o1), Character.toLowerCase(o2)) ;
		}
	};
	
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine().trim());
		StringBuilder sb = new StringBuilder( );
		
		for (int j = 0; j < N; j++) {
			String palabra = in.readLine().trim();
			char[] temp = palabra.toCharArray();
			Character []palabraArray = new Character[temp.length];
			for (int i = 0; i < palabraArray.length; i++) {
				palabraArray[i] = temp[i];
			}
			Arrays.sort(palabraArray, comparador);
			while( palabraArray!=null ){
				for (Character character : palabraArray) {
					sb.append(character);	
				}
				sb.append("\n");
				palabraArray = nextPermutation(palabraArray, comparador, Character.MAX_VALUE);
			}
		}
		System.out.print(new String(sb));
	}

	static <T> T[] nextPermutation(T[] arr, Comparator<? super T> comp, T max_value){
	     int I = -1; T min = null; boolean ws = false;
	     for (int i = arr.length - 1; i >= 0 && !ws; i--) {
	           min = max_value;
	           for(int j = arr.length - 1; j > i && !ws; j--){
	                 min = comp.compare(arr[j], arr[i]) > 0?(comp.compare(arr[j], min) < 0?arr[j]:min):min;
	                 if(ws = comp.compare(arr[i], arr[j]) < 0) I = i;
	           }
	     }
	      if(I == -1)return null;
	      T[] res = (T[])Array.newInstance(arr.getClass().getComponentType(), arr.length), temp = (T[])Array.newInstance(arr.getClass().getComponentType(), arr.length - I);
	     for (int j = I; j < arr.length; j++) temp[j - I] = arr[j];
	     Arrays.sort(temp, comp); ws = false;
	     for (int j = 0, i = 0; j < res.length; j++)
	           if(j <= I)res[j] = j < I?arr[j]:min;
	             else if(!ws && temp[i]==min){i++; res[j]=temp[i++]; ws=true;}
	           else res[j] = temp[i++];
	     return res;
	 }
}
