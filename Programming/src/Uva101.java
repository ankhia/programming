

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&category=24&problem=37&mosmsg=Submission+received+with+ID+10120961
 * @veredict Accepted 
 * @problemId 101
 * @problemName  The Blocks Problem
 * @judge http://uva.onlinejudge.org/
 * @category AdHoc
 * @level easy
 * @date 16/05/2012
 **/ 

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Uva101 {

	static Bloque[] m ;

	static class Bloque {
		Bloque sig;
		Bloque ant;
		int val;

		public String toString(){
			return val+"";
		}
	}

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		while( (linea = in.readLine().trim()) != null){
			StringBuilder sb = new StringBuilder();
			int casos = Integer.parseInt(linea);
			Bloque[] m = new Bloque[casos];
			for (int i = 0; i < casos; i++) {
				m[i]=new Bloque();
				m[i].val = i;
			}
			String[] comando;
			while( !(comando = in.readLine().split(" "))[0].equals("quit") ){
				int a = Integer.parseInt(comando[1].trim());
				int b = Integer.parseInt(comando[3].trim());
				if( a != b ) {
					if(comando[0].equals("move")){
						if(comando[2].equals("onto")){
							if( !estanEnLaMismaPila(m[a], m[b]) ){
								quitarDeEncima(m[a]);
								quitarDeEncima(m[b]);
								if(m[a].ant!=null)
									m[a].ant.sig = null;
								m[b].sig = m[a];
								m[a].ant = m[b];
							}
						}else{ /**over*/
							if( !estanEnLaMismaPila(m[a], m[b]) ){
								quitarDeEncima(m[a]);
								if(m[a].ant!=null)
									m[a].ant.sig = null;
								Bloque aux = m[b];
								while( aux.sig!=null )
									aux = aux.sig;
								aux.sig = m[a];
								m[a].ant = aux;
							}
						}
					}else{ /**pile*/
						if(comando[2].equals("onto")){
							if( !estanEnLaMismaPila(m[a], m[b]) ){
								if(m[a].ant!=null)
									m[a].ant.sig = null;
								quitarDeEncima(m[b]);
								m[b].sig = m[a];
								m[a].ant = m[b];
							}
						}else{/**over*/
							if( !estanEnLaMismaPila(m[a], m[b]) ){
								if(m[a].ant!=null)
									m[a].ant.sig = null;
								Bloque aux = m[b];
								while( aux.sig!=null )
									aux = aux.sig;
								aux.sig = m[a];
								m[a].ant = aux;
							}
						}
					}
				}
			}
			for (int i = 0; i < m.length; i++) {
				sb.append(i+":");
				Bloque aux = m[i];
				if(aux.ant==null) {
					while(aux !=null){
						sb.append(" "+aux.val);
						aux = aux.sig;
					}
				}
				sb.append("\n");	
			}
			System.out.print(new String(sb));
			break;
		}
	}

	static void quitarDeEncima( Bloque x ){
		Bloque aux = x;
		if(aux.sig!=null){
			aux = x.sig;
			while( aux!=null ){
				if(aux.ant!=null)
					aux.ant.sig = null;
				aux.ant = null;
				aux = aux.sig;
			}
		}
	}

	static boolean estanEnLaMismaPila( Bloque a, Bloque b ){
		Bloque aux = null;
		if( b.sig!=null ){
			aux = b.sig;
			while( aux!=null ){
				if(aux.val == a.val){
					return true;
				}
				aux = aux.sig;
			}
		}
		if( a.sig!=null ){
			aux = a.sig;
			while( aux!=null ){
				if(aux.val==b.val)
					return true;
				aux = aux.sig;
			}
		}
		return false;
	}
}