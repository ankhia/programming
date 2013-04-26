

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva11413 {

	static int puntoMedio;
	static int puntoAnterior;
	static int cantidad;
	static int minimoCandidato;
	static int maximo;
	static int minimo;

	public static void main(String[] args) throws Throwable {
		BufferedReader bf = new BufferedReader(new InputStreamReader( System.in));
		String linea;
		while( (linea = bf.readLine()) != null ){
			StringTokenizer st = new StringTokenizer(linea);
			int leche = Integer.parseInt(st.nextToken());
			int contenedores = Integer.parseInt(st.nextToken());
			int cap[] = new int[leche];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < leche; i++) {
				cap[i]=Integer.parseInt(st.nextToken());
			}

			minimo = Integer.MIN_VALUE;
			maximo = 0;
			for (int i = 0; i < cap.length; i++) {
				if(cap[i]>minimo)
					minimo = cap[i];
				maximo+=cap[i];
			}
			if( leche <= contenedores )
				minimoCandidato = minimo;
			else {
				puntoMedio = ( maximo + minimo ) / 2;
				cantidad = 1;
				minimoCandidato = maximo;
				while( minimo < maximo ){
					int copiaPunto = puntoMedio;
					for (int i = 0; i < cap.length; i++) {
						if( (copiaPunto-cap[i]) >= 0 )
							copiaPunto-=cap[i];
						else if( (copiaPunto-cap[i]) < 0 ){
							cantidad++;
							copiaPunto = puntoMedio;
							copiaPunto-=cap[i];
						}
					}
					if( cantidad <= contenedores  ){
						maximo = puntoMedio;
						if( puntoMedio < minimoCandidato)
						minimoCandidato = puntoMedio;
					}
					else	minimo = puntoMedio;
					puntoMedio = ( maximo + minimo ) / 2;
					if(puntoMedio==puntoAnterior)break;
					else puntoAnterior=puntoMedio;
					cantidad = 1;
				}
			}
			System.out.println(minimoCandidato);
		}
	}
}