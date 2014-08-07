
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValidPassword("angie"));
		System.out.println(isValidPassword("angieMilena"));
		System.out.println(isValidPassword("anSo1"));
		System.out.println(isValidPassword("angieMilenaaaa"));
		System.out.println(isValidPassword("angieangieangie"));
		System.out.println(isValidPassword("angieMilena89"));
		
	}
	
	public static boolean isValidPassword( String password ){
		int min_characters = 8;
		int upper = 0, lower = 0, number= 0;
		if( password.length() >= min_characters ) {
			for (int i = 0; i < password.length( ); i++) {
				if( Character.isUpperCase(password.charAt(i)) ){
					upper++;
				}else if( Character.isLowerCase(password.charAt(i))){
					lower++;
				}else if( Character.isDigit(password.charAt(i))){
					number++;
				}
			}
		}
		
		if( upper > 0 && lower > 0 && number > 0 ) return true;
		else return false;
	}

}
