import java.util.ArrayList;
import java.util.TreeMap;


public class Uva386 {

	static TreeMap<Integer, Integer> t;
	static ArrayList[] sol;
	public static void main(String[] args) {
		
		t = new TreeMap<Integer, Integer>();
		int n = 201; 
		
		sol = new ArrayList[n];
		
		for (int i = 0; i < n; i++) {
			t.put( (i*i*i) , i );
		}
		
		for (int i = 2; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				for (int k = j+1; k < n; k++) {
					int m = i*i*i + j*j*j + k*k*k;
					if( t.containsKey(m) ){
						ArrayList<String> num;
						if(sol[t.get(m)]!=null){
							num = sol[t.get(m)] ;
						}else num = new ArrayList<String>();
						num.add("("+i+","+j+","+k+")");
						sol[t.get(m)] = num; 
					}
				}
			}
		}
		
		for (int i = 6; i < n; i++) {
			if(sol[i]!=null){
				for (int j = 0; j < sol[i].size(); j++) {
					System.out.println("Cube = "+i+", Triple = "+sol[i].get(j));
				}
			}
		}
	}
	
	

}
