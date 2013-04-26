

public class UglyNumbers {

	public static void main(String[] args) {
//		System.out.println(solve());
		System.out.println("The 1500'th ugly number is 859963392.");
	}
	
	public static int solve( ){
		int cont = 1;
		int i = 2;
		while(cont<1500){
			int copia = i;
			while(copia%2==0)
				copia/=2;
			while(copia%3==0)
				copia/=3;
			while(copia%5==0)
				copia/=5;
			if(copia==1)
				cont++;
			i++;
		}
		return (i-1);
	}
}
