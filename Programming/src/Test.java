import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Test {

	/**
	 * @param args
	 */
	static private int[][] h;
	private static String[] diasStrings = {"Lunes","Martes","Miercoles", "Jueves", "Viernes", "Sabado"};
	
	private static String[] horasStrings = {"07:00:00 a.m. - 08:30:00 a.m."
			, "08:40:00 a.m. - 10:10:00 a.m."
			, "10:20:00 a.m. - 11:50:00 a.m."
			, "12:00:00 p.m. - 01:30:00 p.m."
			, "01:40:00 p.m. - 03:10:00 p.m."
			, "03:20:00 p.m. - 04:50:00 p.m."
			, "05:00:00 p.m. - 06:30:00 p.m."
			, "06:40:00 p.m. - 08:10:00 p.m."
			, "08:20:00 p.m. - 09:50:00 p.m."
	};
	
	private List<Dia> dias;
	
	private List<Hora> horas;
	
	private static int[ ][ ] salones; 
	
	public static void main(String[] args) {
//		System.out.println(isValidPassword("angie"));
//		System.out.println(isValidPassword("angieMilena"));
//		System.out.println(isValidPassword("anSo1"));
//		System.out.println(isValidPassword("angieMilenaaaa"));
//		System.out.println(isValidPassword("angieangieangie"));
//		System.out.println(isValidPassword("angieMilena89"));
		
		salones = new int[ horasStrings.length ][ diasStrings.length ];
		int a = 1;
		for (int i = 0; i < salones.length; i++) 
			Arrays.fill(salones[i], 300);
		
		for (int i = 0; i < salones.length; i++) 
			System.out.println(Arrays.toString(salones[i]));
		
		for (int i = 0; i < diasStrings.length; i++) {
			for (int j = 0; j < horasStrings.length; j++) {
				System.out.print(" "+salones[j][i]);
			}
			System.out.println();
		}
		
	}
	
	public List<Clase> getClases( Materia m ){
		List<Clase> clases = new ArrayList<Clase>( );
		int cantSesiones = m.getCantidadSesiones( );
		if( cantSesiones == 3 ){
			for (int i = 0; i < diasStrings.length && clases.size() < cantSesiones; i++) {
				Clase clase = new Clase( );
				for (int j = 0; j < horasStrings.length; j++) {
					if( salones[j][i] > 0 ){
						Bloque b = getBloque(i, j);
						clase.setBloque(b);
						clases.add(clase);
						i+=2;
						break;
					}
				}
			}
		}else if( cantSesiones == 2 ){
			
		}
		return clases;
	}
	
	public Bloque getBloque( int dia, int hora ){
		Bloque bloque = new Bloque( );
		bloque.setDia(dias.get(dia));
		bloque.setHora1(horas.get(hora));
		bloque.setHora1(horas.get(hora+1));
		return bloque;
	}
	
//	public static boolean isValidPassword( String password ){
//		int min_characters = 8;
//		int upper = 0, lower = 0, number= 0;
//		if( password.length() >= min_characters ) {
//			for (int i = 0; i < password.length( ); i++) {
//				if( Character.isUpperCase(password.charAt(i)) ){
//					upper++;
//				}else if( Character.isLowerCase(password.charAt(i))){
//					lower++;
//				}else if( Character.isDigit(password.charAt(i))){
//					number++;
//				}
//			}
//		}
//		
//		if( upper > 0 && lower > 0 && number > 0 ) return true;
//		else return false;
//	}
//	

}



class Materia{
	private String materia;
	private int cantidadSesiones;
	
	public Materia(){
	}
	
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public int getCantidadSesiones() {
		return cantidadSesiones;
	}
	public void setCantidadSesiones(int cantidadSesiones) {
		this.cantidadSesiones = cantidadSesiones;
	}
}

class Clase{
	private Bloque b ;
	public Clase(){
	}
	public Bloque getBloque() {
		return b;
	}
	public void setBloque(Bloque b) {
		this.b = b;
	}
}

class Bloque {
	private Dia d ;
	private Hora horaini;
	private Hora horafin;
	
	public Bloque( ){
		
	}

	public Dia getDia() {
		return d;
	}

	public void setDia(Dia d) {
		this.d = d;
	}

	public Hora getHora1() {
		return horaini;
	}

	public void setHora1(Hora horaini) {
		this.horaini = horaini;
	}

	public Hora getHora2() {
		return horafin;
	}

	public void setHora2(Hora horafin) {
		this.horafin = horafin;
	}
	
}

class Hora{
	int hora;
	int minuto;
	public Hora( ){
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public int getMinuto() {
		return minuto;
	}
	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}
	
	
}

class Dia{
	private String dia;
	private int id;
	
	public Dia( ){
		
	}
	
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}