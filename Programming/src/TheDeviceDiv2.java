

public class TheDeviceDiv2 {

	public static void main(String[] args) {
		System.out.println(new TheDeviceDiv2().identify(new String[]{"000","111"}));
	}
	
	public String identify(String[] plates){
//		for ( int j = 0 ;  j < ; i++ )
//			for (int j = 0; j < plates.length; j++) 
				return null;
	}
	
	public static int getMoves(int[] S, int[]T){
		int suma = 0;
		for (int i = 0; i < S.length; i++) {
			if(S[i]>T[i])
				suma+=S[i]-T[i];
		}
		return suma;
	}
	
	static boolean nextPermutation(int[] p){
    	int k,l,aux,i,j;
    	for (k = p.length-1; k>0 && p[k-1]>=p[k]; k--);
    	if (k!=0){
          	for (l = p.length-1; l>0 && p[k-1]>=p[l]; l--);
          	aux=p[k-1]; p[k-1]=p[l]; p[l]=aux;
          	for (i = k, j = p.length-1; i<j ; i++,j--){
                	aux=p[i]; p[i]=p[j]; p[j]=aux;
          	}
          	return true;
    	} 	
    	else return false;
	}
	
}
