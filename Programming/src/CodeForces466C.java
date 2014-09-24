
public class CodeForces466C {

	static int valor[];
	static int n;
	public static void main(String[] args) {
		valor = new int[]{1,3,6,6,9};
		n = valor.length;
		System.out.println("--->"+ways(1, 1));
		for (int j = 1; j < n-1 ; j++) {
			for (int i = 1; i <= j; i++) {
				System.out.println(esSol(i, j));
			}
		}
	}
	
	static int ways( int i , int j ){
		if( i > j ) return 0;
		if( j >= n-1 ) return 0;
		return  ( esSol(i+1, j)? ways(i+1,j)+1:0 ) +  ( esSol(i, j+1)? ways(i,j+1)+1:0 ) + ( esSol(i+1, j+1)? ways(i+1,j+1)+1:0 );  
	}
	
	static boolean esSol( int i , int j ){
		System.out.println(i +" " +j);
		System.out.println(valor[i-1] +" " + ( valor[j]-valor[i-1] ) + " " + (valor[n-1]-valor[j+1] ));
		if( valor[i-1] == ( valor[j]-valor[i-1] ) && valor[i-1] == (valor[n-1]-valor[j+1] ))
			return true;
		return false;
	}
	

}
