

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Uva12526 {

	static class Trie {
		 
	  	//máximo número prefijos.
	  	static int N=500000;
	 
	  	int[][] nodes = new int[N][27];
	  	int nNodes;
	  	String[] list;
	  	int nList;
	  	
	  	void initTrie(){
	        	for (int i = 0; i < N; i++) {
	              	Arrays.fill(nodes[i], -1);
	        	}
	        	nNodes = 1;
	  	}
	  	
	  	void insert(String ss){
	        	char[] s = ss.toCharArray();
	        	int node = 0;
	        	for (int i = 0; i < s.length; i++) {
	              	int let = (int)(s[i]-'a');
	              	if (nodes[node][let] == -1){
	                    	nodes[node][let] = nNodes;
	                    	node = nNodes;
	                    	nNodes++;
	              	}else node = nodes[node][let];
	        	}
	  	}
	  	
	  	void listPrefix(){
	        	list = new String[nNodes];
	        	nList = 0;
	        	listPrefixRec("",0);
	  	}
	  	
	  	void listPrefixRec(String pre, int node){
	        	if (node>=nNodes) return;
	        	list[nList] = pre;
	        	nList++;
	        	for (int i = 0; i < 26; i++) {
	              	if (nodes[node][i]!=-1)
	                    	listPrefixRec(pre+((char)(i+'a')), nodes[node][i]); 
	        	}
	  	}
	  	
	  	int recorrerTrie( int node , int pul ){
	  		int suma = 0;
	  		Queue< Integer > cola = new LinkedList<Integer>();
	  		for (int i = 0; i < 27; i++) {
	  			if( nodes[node][i] != -1 ){
	  				cola.add(i);
//	  				System.out.print("  " + (char) (i+'a'));
	  			}
			}
//	  		System.out.println();
	  		boolean tengoHermanos = cola.size()>1;
	  		while( !cola.isEmpty() ){
	  			int act = cola.poll();
	  			if( act!=26 && tengoHermanos){
	  				suma+=recorrerTrie(nodes[node][act], pul+1);
	  			}
	  			else if(act!=26 && !tengoHermanos){
	  				suma+=recorrerTrie(nodes[node][act], pul==0?1:pul);
	  			}
	  			else{
	  				suma+=pul;
	  			}
	  		}
	  		return suma;
	  	}
	}
	
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Trie t = new Trie( );
		for (String linea; (linea = in.readLine()) != null; ) {
			int n = Integer.parseInt(linea);
			t.initTrie();
			for (int c = 0; c < n; c++) {
				String s = in.readLine()+(char)('z'+1);
				t.insert(s);
			}
			System.out.printf("%.2f\n",(double)(t.recorrerTrie(0, 0))/n);
		}
	}
}
