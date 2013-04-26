
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=3&page=show_problem&problem=59
 * @veredict Accepted 
 * @problemId 123
 * @problemName  Searching Quickly
 * @judge http://uva.onlinejudge.org/
 * @category NO C
 * @level easy
 * @date 10/01/2012
 **/ 

public class Uva123 {
	
	private static ArrayList<String> pIgnorar;
	private static ArrayList<String> titulos;
	private static TreeSet<String> keyWords; 
	private static boolean bln;
	public static void main(String ... args) throws Exception{
//		BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("hola.in")));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		pIgnorar = new ArrayList<String>();
		titulos = new ArrayList<String>();
		keyWords = new TreeSet<String>();
		String linea;
		bln = true;
		while((linea=bf.readLine())!=null){
			if(linea.equals("::"))
				bln=false;

			if(bln)
				pIgnorar.add(linea);
			else{
				if(!linea.equals("::"))
					titulos.add(linea);
			}
		}
		for(int i=0; i<titulos.size();++i){
			String titulo = titulos.get(i);
			String[] palabras = titulo.split(" ");
			for(int j=0; j<palabras.length; ++j){
				if(noIgnorar(palabras[j])){
					String pal = "";
					for (int k = 0; k < palabras[j].length(); k++) {
						//if(Character.isLetter(palabras[j].charAt(k)))
							pal+=palabras[j].charAt(k);
					}
					keyWords.add(pal.toLowerCase());
				}
			}
		}
//		imprimir();
		StringBuilder sb = new StringBuilder();
		for(Iterator<String> it = keyWords.iterator();it.hasNext();){
			String key = it.next();
			for (int j = 0; j < titulos.size(); j++) {
				String titulo = titulos.get(j).toLowerCase();
				if(titulo.indexOf(key.toLowerCase())!=-1 && !key.equals("")){
					ArrayList<Integer> indices = darIndices(titulo,key);
					for(int k = 0; k<indices.size();++k){
						String aux = (titulo.substring(0, indices.get(k)))+key.toUpperCase()+(titulo.substring(indices.get(k)+key.length())+"\n");
						sb.append(aux);
					}
				}
			}
		}
		System.out.print(new String(sb));
	}
	
	
	
	private static ArrayList<Integer> darIndices(String titulo, String key) {
		ArrayList<Integer> indices = new ArrayList<Integer>();
		String palabra = "",palAux="";
		int aux = 0;
		for (int i = 0; i < titulo.length(); i++) {
			char caracter = titulo.charAt(i);
			if(caracter!=' '){
				if(Character.isLetter(caracter))
					palabra+=caracter;
				else{
					palAux=palabra+caracter;
					aux++;
				}
			}
			else{
//				if(palabra.length()==key.length()){
//					int cantLetras=0;
//					for(int p=0;p<palabra.length();++p){
//						if(Character.isLetter(palabra.charAt(p)) && palabra.charAt(p)==key.charAt(p))
//					}
//				}
				if(palabra.equalsIgnoreCase(key)){
					indices.add(i-palabra.length()-aux);
				}else if(palAux.equalsIgnoreCase(key)){
					indices.add(i-palAux.length());
				}
				palabra = "";
				palAux="";
				aux=0;
			}
		}
		
		if(palabra.equalsIgnoreCase(key)){
			indices.add(titulo.length()-palabra.length()-aux);
		}else if(palAux.equalsIgnoreCase(key)){
			indices.add(titulo.length()-palAux.length());
		}
		return indices;
	}
	private static boolean noIgnorar(String string) {
		for(int i=0;i<pIgnorar.size();++i){
			if(pIgnorar.get(i).equalsIgnoreCase(string))
				return false;
		}
		return true;
	}

	public static void imprimir(){
		System.out.println("----------------------");
		for(int i=0;i<pIgnorar.size();++i){
			System.out.println(pIgnorar.get(i)+" ");
		}
		System.out.println("----------------------");
		for(int i=0;i<titulos.size();++i){
			System.out.println(titulos.get(i)+" ");
		}
	
		System.out.println("----------------------");
		for(Iterator<String> it = keyWords.iterator();it.hasNext();){
			System.out.println(it.next());
		}
		
	}
}
