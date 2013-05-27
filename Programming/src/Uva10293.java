import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;


public class Uva10293 {

	static TreeMap<Integer, Integer> tree;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		tree = new TreeMap<Integer, Integer>();
		int k = 0;
		int cantLetras = 0;
		for (String line ; (line = in.readLine())!=null; k++) {
			line = line.trim();
			if(line.startsWith("#")){
				for (Integer i : tree.keySet()) {
					sb.append(i +" "+ tree.get(i)+"\n");
				}
				sb.append("\n");
				tree = new TreeMap<Integer, Integer>(); 
			}

			for (int i = 0; i < line.length(); i++) {
				char actual = line.charAt(i);
				if(Character.isLetter(actual)){
					cantLetras++;
				}else if( cantLetras != 0 && actual != '-' && actual != '\'' ){
					if( tree.containsKey(cantLetras) )
						tree.put(cantLetras, tree.get(cantLetras)+1);
					else
						tree.put(cantLetras, 1);
					cantLetras=0;
				}
				if( i == line.length() - 1 && actual != '-' && cantLetras != 0){
					if( tree.containsKey(cantLetras) )
						tree.put(cantLetras, tree.get(cantLetras)+1);
					else
						tree.put(cantLetras, 1);
					cantLetras=0;
				}
			}
			
		}
		String n = sb.substring(0, sb.length()-1);
		System.out.print(n);
	}

}
