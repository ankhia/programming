import java.io.BufferedReader;
import java.io.InputStreamReader;


public class RangeMinimumQueryJonas {

	static int[] start;
	static int[] end;
	static int[] range;
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	}

	public void build_segment( int s, int e, int index ){

	}

	public void update_segment( int index ){

	}

	public int query( int s , int e , int index ){
		return 0;
	}

	public static int parent( int i ){      
		return (int)(Math.ceil((double)i/2)-1); 
	}
	public static int leftChild( int i ){   
		return 2*i+1;                                   
	}
	public static int rightChild( int i ){
		return 2*i+2;                                   
	}
}
