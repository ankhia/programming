

//AUN NO ESTAAAAAAAAAAAAAAAAAAAA
public class Uva11121 {

	public static void main(String[] args) {
		System.out.println(fromDecimal(7, (-2)));
		System.out.println(7%(-2));
	}
	
	public static int fromDecimal(int n, int b){
	   int result=0;
	   int multiplier=1;
	   while(n>0){
	      result+=n%b*multiplier;
	      multiplier*=10;
	      n/=b;
	   }
	   return result;
	}
}
