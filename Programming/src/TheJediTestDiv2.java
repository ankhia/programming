

public class TheJediTestDiv2 {

	
	static int [] studentsA ;
	static int YA;
	static int JA;
	public static void main(String[] args) {
		System.out.println(new TheJediTestDiv2().countSupervisors(new int[]{4, 7, 10, 5, 6, 55, 2}, 20, 3));
	}

	public static int countSupervisors(int[] students, int Y, int J){
		studentsA = students;
		YA=Y;
		JA=J;
		return f(  );
		
	}
	
	public static int f(  ){
		int minimo = Integer.MAX_VALUE;
		for (int j = 0; j < studentsA.length; j++) {
			int sum = sumaJedis(j);
			if(sum < minimo)
				minimo = sum;
		}
		return minimo;
	}

	private static int sumaJedis(int i) {
		int suma = 0;
		for (int j = 0; j < studentsA.length; j++) {
			if(j!=i)
				suma+=studentsA[j];
			else if(studentsA[j]-YA > 0)
					suma+=studentsA[j];
		}
		
		return (int) Math.ceil(suma/JA);
	}	
}
