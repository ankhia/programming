import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class CodeForces471B {

	static Comparator< Integer > comp = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			 return o1-o2;
		}
	};
	
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in))  ;
		int n = Integer.parseInt(in.readLine());
		Integer[] v = new Integer[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < v.length; i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(v);
		System.out.println(Arrays.toString(v));
		ArrayList<Integer[]> perms = new ArrayList<Integer[]>();
		Integer[] first = next_permutation(v, comp , Integer.MAX_VALUE);
		while ( first != null && perms.size() < 3) {
			perms.add(first);
			first = next_permutation(first, comp , Integer.MAX_VALUE);
		}
		boolean sePuede=perms.size()>=3;
		System.out.println(sePuede?"YES":"NO");
		for (int i = 0; i < v.length; i++) {
			System.out.println(Arrays.toString(perms.get(i)));
		}
	}
	
	static boolean sirve( Integer[] a ){
		Integer[] cpy = a.clone();
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			if( cpy[i]!=a[i] )
				return false;
		}
		return true;
	}
	
	static Integer[] next_permutation(Integer[] arr, Comparator<? super Integer> comp, Integer max_value){
    	int I = -1; Integer min = null; boolean ws = false;
    	for (int i = arr.length - 1; i >= 0 && !ws; i--) {
          	min = max_value;
          	for(int j = arr.length - 1; j > i && !ws; j--){
                	min = comp.compare(arr[j], arr[i]) > 0?(comp.compare(arr[j], 		min) < 0?arr[j]:min):min;
                	if(ws = comp.compare(arr[i], arr[j]) < 0) I = i;
          	}
    	}
    	if(I == -1)return null;
    	Integer[] res = (Integer[])Array.newInstance(arr.getClass().getComponentType(),arr.length), temp =(Integer[])Array.newInstance(arr.getClass().getComponentType(), arr.length - I);
    	for (int j = I; j < arr.length; j++) temp[j - I] = arr[j];
    	Arrays.sort(temp, comp); ws = false;
    	for (int j = 0, i = 0; j < res.length; j++)
          	if(j <= I)res[j] = j < I?arr[j]:min;
          			else if(!ws && temp[i]==min){i++; res[j]=temp[i++]; ws=true;}
          	else res[j] = temp[i++];
    	return res;
	}
}
