import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class review {

	static boolean []mal;
	static int[] contReview;
	static TreeMap<String, ArrayList<Integer>> code;
	static ArrayList<ArrayList<Integer>> array;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line; (line=in.readLine())!=null; ) {
			StringTokenizer st = new StringTokenizer(line);

			int rev = Integer.parseInt(st.nextToken());
			int pap = Integer.parseInt(st.nextToken());

			if(rev == 0 && pap == 0) break;
			array = new ArrayList<ArrayList<Integer>>();
			code = new TreeMap<String, ArrayList<Integer>>();

			mal = new boolean[pap];
			contReview = new int[pap];

			for (int i = 0; i < pap; i++) {
				st = new StringTokenizer(in.readLine());
				String un = st.nextToken();
				if(code.containsKey(un)){
					code.get(un).add(i);
				}else{
					ArrayList<Integer> id = new ArrayList<Integer>();
					id.add(i);
					code.put(un, id);
				}

				ArrayList<Integer> papers  = new ArrayList<Integer>();
				while(st.hasMoreTokens()){
					int aGuardar = Integer.parseInt(st.nextToken())-1;
					if(papers.contains(aGuardar))
						mal[aGuardar] = true;
					papers.add(aGuardar);
				}
				array.add(papers);
			}

			for(String key : code.keySet() ){
				ArrayList<Integer> posiciones = code.get(key);
				for (int i = 0; i < posiciones.size(); i++) {
					ArrayList<Integer> paperRevisados = array.get(posiciones.get(i));
					for (int j = 0; j < paperRevisados.size(); j++) {
						for (int k = 0; k < posiciones.size(); k++) {
							if(paperRevisados.get(j).equals(posiciones.get(k))){
								mal[paperRevisados.get(j)]=true;
							}					
						}
						contReview[paperRevisados.get(j)]++;
					}
				}
			}
			
			for (int i = 0; i < contReview.length; i++) {
				if(contReview[i]<rev || contReview[i]>rev)
					mal[i] = true;
			}
			
			int cont = 0;
			for (int i = 0; i < mal.length; i++) {
				if( mal[i] )
					cont++;
			}
			if(cont == 0)
				sb.append("NO PROBLEMS FOUND");
			else if (cont == 1){
				sb.append("1 PROBLEM FOUND");
			}else{
				sb.append(cont+" PROBLEMS FOUND");	
			}
			sb.append("\n");
		}
		System.out.print(new String(sb));
	}
}

