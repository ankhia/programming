import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;


public class CodeforceRegistrationSystem {

	static HashMap<String, Integer> h;
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder( );
		h = new HashMap<String, Integer>();
		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			String line = in.readLine();
			if(h.containsKey(line)){
				String nName = line+(h.get(line)); 
				h.put(nName, 1);
				h.put(line, h.get(line)+1);
				sb.append(nName+"\n");
			}else{
				h.put(line, 1);
				sb.append("OK\n");
			}
		}
		System.out.print(new String(sb));
	}

}
