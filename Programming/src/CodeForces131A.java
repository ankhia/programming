import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CodeForces131A {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String line; (line = in.readLine())!= null; ) {
			StringBuilder sb = new StringBuilder();
			boolean isCapsLock = true;
			for (int i = 0; i < line.length() && isCapsLock; i++) {
				char charAt = line.charAt(i);
				if( Character.isLowerCase(charAt) && i != 0){
					isCapsLock = false;
				}else if( Character.isUpperCase(charAt) ){
					sb.append(Character.toLowerCase(charAt));
				}else{
					sb.append(Character.toUpperCase(charAt));
				}
			}
			if(isCapsLock)
				System.out.println(new String(sb));
			else
				System.out.println(line);
			
		}
	}
}
