

public class bitwaise {

	public static void main(String[] args) {
		for (int i = 0, j; ( j = 1<<i )< 10; i++) {
			System.out.println(i+"  "+ j);
		}
	}
}
