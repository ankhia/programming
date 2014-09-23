import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Uva11507 {

	static TreeMap<String, TreeMap<String, String>> tree;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		init();
		StringBuilder sb = new StringBuilder( );
		for(String line; (line=in.readLine())!=null; ){
			String last = "+x";
			int l = Integer.parseInt(line);
			if(l==0)break;
			StringTokenizer st = new StringTokenizer(in.readLine());
			while (st.hasMoreTokens()) 
				last = tree.get(last).get(st.nextToken());
			sb.append(last).append("\n");
		}
		System.out.print(new String(sb));
	}

	static void init( ){
		tree = new TreeMap<String, TreeMap<String,String>>();
		
		tree.put("+y", new TreeMap<String, String>());
		tree.put("+x", new TreeMap<String, String>());
		tree.put("+z", new TreeMap<String, String>());
		tree.put("-y", new TreeMap<String, String>());
		tree.put("-x", new TreeMap<String, String>());
		tree.put("-z", new TreeMap<String, String>());
		
		tree.get("+y").put("+y", "-x");
		tree.get("+y").put("-y", "+x");
		tree.get("+y").put("+z", "+y");
		tree.get("+y").put("-z", "+y");
		tree.get("+y").put("No", "+y");
		
		tree.get("-y").put("+y", "+x");
		tree.get("-y").put("-y", "-x");
		tree.get("-y").put("+z", "-y");
		tree.get("-y").put("-z", "-y");
		tree.get("-y").put("No", "-y");
		
		tree.get("+x").put("+y", "+y");
		tree.get("+x").put("-y", "-y");
		tree.get("+x").put("+z", "+z");
		tree.get("+x").put("-z", "-z");
		tree.get("+x").put("No", "+x");
		
		tree.get("-x").put("+y", "-y");
		tree.get("-x").put("-y", "+y");
		tree.get("-x").put("+z", "-z");
		tree.get("-x").put("-z", "+z");
		tree.get("-x").put("No", "-x");
		
		tree.get("-z").put("+y", "-z");
		tree.get("-z").put("-y", "-z");
		tree.get("-z").put("+z", "+x");
		tree.get("-z").put("-z", "-x");
		tree.get("-z").put("No", "-z");
		
		tree.get("+z").put("+y", "+z");
		tree.get("+z").put("-y", "+z");
		tree.get("+z").put("+z", "-x");
		tree.get("+z").put("-z", "+x");
		tree.get("+z").put("No", "+z");
	}
	
}
