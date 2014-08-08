import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class regex {

	static Pattern pattern = Pattern.compile("([0-9a-zñA-ZÑ]*[0-9]+[0-9a-zñA-ZÑ]*[a-zñ]+[0-9a-zñA-ZÑ]*[A-ZÑ]+[0-9a-zñA-ZÑ]*)|([0-9a-zñA-ZÑ]*[0-9]+[0-9a-zñA-ZÑ]*[A-ZÑ]+[0-9a-zñA-ZÑ]*[a-zñ]+[0-9a-zñA-ZÑ]*)|([0-9a-zñA-ZÑ]*[a-zñ]+[0-9a-zñA-ZÑ]*[0-9]+[0-9a-zñA-ZÑ]*[A-ZÑ]+[0-9a-zñA-ZÑ]*)|([0-9a-zñA-ZÑ]*[a-zñ]+[0-9a-zñA-ZÑ]*[A-ZÑ]+[0-9a-zñA-ZÑ]*[0-9]+[0-9a-zñA-ZÑ]*)|([0-9a-zñA-ZÑ]*[A-ZÑ]+[0-9a-zñA-ZÑ]*[0-9]+[0-9a-zñA-ZÑ]*[a-zñ]+[0-9a-zñA-ZÑ]*)|([0-9a-zñA-ZÑ]*[A-ZÑ]+[0-9a-zñA-ZÑ]*[a-zñ]+[0-9a-zñA-ZÑ]*[0-9]+[0-9a-zñA-ZÑ]*)");
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Matcher matcher = pattern.matcher("ñ0Ñ");

		boolean found = false;
		while(matcher.find()) {
		  System.out.println("Found the text \"" + matcher.group() +  "\" starting at index " + matcher.start() +
		      " and ending at index " + matcher.end() + ".");
		  found = true;
		}

		if(!found){
		  System.out.println("No match found.");
		}
		String[] pat = {"[0-9]","[a-zñ]" ,"[A-ZÑ]"};
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < pat.length; i++) {
			for (int j = 0; j < pat.length; j++) {
				for (int k = 0; k < pat.length; k++) {
					if( i != j && j != k && i != k ){
						sb.append("([0-9a-zñA-ZÑ]*"+pat[i]+"+[0-9a-zñA-ZÑ]*"+pat[j]+"+[0-9a-zñA-ZÑ]*"+pat[k]+"+[0-9a-zñA-ZÑ]*)|" );
					}
				}
			}
		}
			
		System.out.println(new String(sb));
	}
	
	public static boolean isValidPassword( String password ){
		Matcher matcher = pattern.matcher(password);
		boolean found = false;
		int min_characters = 8;
		if( password.length() >= min_characters ) {
			while(matcher.find()) {
				  found = true;
			}
		}
		return found;
	}
	
	
	
	
	
}
