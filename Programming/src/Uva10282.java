import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Uva10282 {

	static TreeMap<String, String> words;
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		words = new TreeMap<String, String>();
		StringBuilder sb = new StringBuilder();
		boolean dictionary = true;
		for(String ln; (ln = in.readLine())!=null; ){
			if( ln.length() > 0 && dictionary ){
				StringTokenizer st = new StringTokenizer(ln);
				String english = st.nextToken();
				String foreign = st.nextToken();
				words.put(foreign, english);
			}else if(ln.length() > 0){
				sb.append(words.containsKey(ln)? words.get(ln):"eh").append("\n");
			}
			if(ln.length() == 0) dictionary = false;
		}
		System.out.print(new String(sb));
	}

}
