import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;


public class Uva10098 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) ) ;
		int n = Integer.parseInt(in.readLine().trim());
		StringBuilder sb = new StringBuilder( );
		for (int i = 0; i < n; i++) {
			String palabra = in.readLine();
			char[] temp = palabra.toCharArray();
			Arrays.sort(temp);
			while( temp!=null ){
				for (char character : temp) {
					sb.append(character);	
				}
				sb.append("\n");
				temp = nextPermutation(temp);
			}
//			if( i < n-1 ) 
				sb.append("\n");
		}
		System.out.print(new String(sb));
	}
	
	static char[] nextPermutation(char[] arr){
		int I = -1; char min = '\0';
		for(int i = arr.length-1; i >= 0; i-- ){
			boolean ws = false; min=Character.MAX_VALUE; 
			for(int j = arr.length-1;j>i && !ws; j--){
				min=arr[j] > arr[i]?(char)Math.min(arr[j], min):min;
				if(ws = arr[i]<arr[j]) I = i;
			}
			if(ws)break;
		}
		if(I==-1) return null;
		char[] res = new char[arr.length]; char[] temp = new char[arr.length - I];
		for (int j = I; j < arr.length; j++) temp[j - I] = arr[j];
		Arrays.sort(temp); boolean ws = false;
		for(int j = 0, i = 0; j < res.length; j++ )
			if( j <= I ) res[j] = j < I ? arr[j]:min;
			else if(!ws && temp[i]==min){i++;res[j]=temp[i++];ws=true;}
			else res[j] = temp[i++];
		return res;
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
