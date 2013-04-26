

public class GogoXBallsAndBinsEasy {

	public static void main(String[] args) {
		System.out.println(new GogoXBallsAndBinsEasy().solve(new int[]{0,2,5}));
	}
	
	public static int solve(int[] T){
		int mayor = Integer.MIN_VALUE;
		int[] copiaT = T.clone();
		while(nextPermutation(copiaT)){
			int[] copiaS = copiaT.clone();
			int moves = getMoves(copiaS, T);
			if(moves>mayor)
				mayor = moves;
		}
		return mayor;
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
